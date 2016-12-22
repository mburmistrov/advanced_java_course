package edu.technopolis.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mmb on 22.12.16.
 */
public class LFUCache {

    private static int initialCapacity;

    private static HashMap<Integer, CacheNode> cacheMap = new HashMap<Integer, CacheNode>();

    public LFUCache()
    {
        this.initialCapacity = 10;
    }

    public void addNode(int key, String data)
    {
        if(!isFull())
        {
            CacheNode temp = new CacheNode();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        }
        else
        {
            int entryKeyToBeRemoved = getLFUKey();
            cacheMap.remove(entryKeyToBeRemoved);

            CacheNode temp = new CacheNode();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        }
    }

    public int getLFUKey()
    {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for(Map.Entry<Integer, CacheNode> entry : cacheMap.entrySet())
        {
            if(minFreq > entry.getValue().frequency)
            {
                key = entry.getKey();
                minFreq = entry.getValue().frequency;
            }
        }

        return key;
    }

    public String getNode(int key)
    {
        if(cacheMap.containsKey(key))
        {
            CacheNode temp = cacheMap.get(key);
            temp.frequency++;
            cacheMap.put(key, temp);
            return temp.data;
        }
        return null;
    }

    public static boolean isFull()
    {
        if(cacheMap.size() == initialCapacity)
            return true;

        return false;
    }
}