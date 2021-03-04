package com.jwj.concurrency;

import net.jcip.examples.LaunderThrowable;

import java.util.List;
import java.util.concurrent.*;

/**
 * 使用CompletionService完成页面渲染，将图片数据和文本数据分开渲染
 *
 * @author jiangwenjie
 * @since 1.0
 */
public abstract class Renderer {

    private final ExecutorService executor;

    protected Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source){
        final List<ImageInfo> info=scanForImageInfo(source);
        CompletionService<ImageData> completionService=new ExecutorCompletionService<>(executor);
        for (final ImageInfo imageInfo:info){
            completionService.submit(imageInfo::downloadImage);
        }
        renderText(source);

        for (int t = 0; t < info.size(); t++) {
            try {
                Future<ImageData> f=completionService.take();
                ImageData imageData=f.get();
                renderImage(imageData);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                throw LaunderThrowable.launderThrowable(e.getCause());
            }

        }
    }

    interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);
}
