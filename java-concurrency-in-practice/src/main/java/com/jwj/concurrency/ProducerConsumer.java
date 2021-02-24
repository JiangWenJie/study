package com.jwj.concurrency;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 生产者/消费者模式的实现
 * 生产者 FileCrawler：按照某种规律扫描磁盘上的文件
 * 消费者 Indexer：给文件建立索引
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<>(10);
        FileFilter filter = pathname -> true;
        File[] roots = new File[3];
        roots[0] = new File("/Users/jiangwenjie/IdeaProjects/study/algorithms");
        roots[1] = new File("/Users/jiangwenjie/IdeaProjects/study/java-8-lambdas");
        roots[2] = new File("/Users/jiangwenjie/IdeaProjects/study/netty");
        for (File root : roots) {
            new Thread(new FileCrawler(queue, filter, root)).start();
        }

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            new Thread(new Indexer(queue)).start();
        }

    }
}

class FileCrawler implements Runnable {
    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;

    FileCrawler(BlockingQueue<File> fileQueue, final FileFilter fileFilter, File root) {
        this.fileQueue = fileQueue;
        this.fileFilter = f -> f.isDirectory() || fileFilter.accept(f);
        this.root = root;
    }

    @Override
    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles(fileFilter);
        if (entries != null) {
            for (File entry : entries) {
                if (entry.isDirectory()) {
                    crawl(entry);
                } else {
                    fileQueue.put(entry);
                }
            }
        }
    }
}

class Indexer implements Runnable {

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    private final BlockingQueue<File> queue;

    @Override
    public void run() {
        File file = null;
        do {
            try {
                file = queue.poll(5, TimeUnit.SECONDS);
                if (file != null) {
                    indexFile(file);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } while (file != null);
    }

    public void indexFile(File file) {
        System.out.println(file.getAbsolutePath() + "/" + file.getName());
    }
}