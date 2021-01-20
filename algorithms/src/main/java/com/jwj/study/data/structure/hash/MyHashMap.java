package com.jwj.study.data.structure.hash;

/**
 * @author jwj
 * @date 2021/1/6 20:55
 * @description hashMap实现
 * @since 1.0
 */
public class MyHashMap implements IMyHashMap {
    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Entry[] table;
    private int size;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int threshold;

    @Override
    public void put(String key, String value) {
        if (key == null) {
            throw new IllegalArgumentException("key must not null");
        }
        // 初始化数组
        if (null == table || 0 == table.length) {
            table = new Entry[DEFAULT_INITIAL_CAPACITY];
            threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }
        int hash = hash(key,table.length);
        if (null == table[hash]) {
            // 初始化桶
            table[hash] = new Entry(hash, key, value, null);
            size++;
        } else {
            size++;
            if (size>threshold){
                resize();
            }
            Entry newE = getEntry(key);
            if (null == newE) {
                Entry e = new Entry(hash, key, value, table[hash]);
                table[hash] = e;
            } else {
                newE.value = value;
            }
        }
    }

    private void resize() {
        Entry[] newTable=new Entry[table.length*2];
        Entry[] oldTable=table;
        for (int i=0;i<oldTable.length;i++){
            Entry e=oldTable[i];
            if (e!=null){
                oldTable[i]=null;
                do {
                    Entry next=e.next;
                    int index=hash(e.key,newTable.length);
                    e.next=newTable[index];
                    newTable[index]=e;
                    e=next;
                }while (e!=null);
            }
        }
        table=newTable;
        threshold*=2;
    }

    @Override
    public String get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("key must not null");
        }
        Entry e = getEntry(key);
        return null == e ? null : e.value;
    }

    private Entry getEntry(String key) {
        int hash = hash(key,table.length);
        for (Entry e = table[hash]; e != null; e = e.next) {
            if (e.hash == key.hashCode() && e.key .equals(key) || e.key.equals(key)) {
                return e;
            }
        }
        return null;
    }

    private int hash(String key,int capacity) {
        return key.hashCode() % capacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            result.append(i + ":");
            Entry temp = table[i];
            while (null != temp) {
                result.append("->" + temp.value);
                temp = temp.next;
            }
            result.append("\n");
        }
        return result.toString();
    }

    class Entry {
        final int hash;
        final String key;
        String value;
        Entry next;

        public Entry(int hash, String key, String value, Entry next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
