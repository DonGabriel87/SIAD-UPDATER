package Classes.Core.App;

import java.util.Stack;

public abstract class Cache {
    private static String despath;
    private static String oripath;
    private static int totalMovedFiles;
    private static int totalUnMovedFiles;

    public static String getDespath() {
        return despath;
    }

    public static void setDespath(String despath) {
        Cache.despath = despath;
    }

    public static String getOripath() {
        return oripath;
    }

    public static void setOripath(String oripath) {
        Cache.oripath = oripath;
    } 

    public static int getTotalMovedFiles() {
        return totalMovedFiles;
    }

    public static void setTotalMovedFiles(int totalMovedFiles) {
        Cache.totalMovedFiles = totalMovedFiles;
    }

    public static int getTotalUnMovedFiles() {
        return totalUnMovedFiles;
    }

    public static void setTotalUnMovedFiles(int totalUnMovedFiles) {
        Cache.totalUnMovedFiles = totalUnMovedFiles;
    }

    
    
    public static void disposeData() {
        Cache.despath = null;
        Cache.oripath = null;
        Cache.totalMovedFiles = 0;
        Cache.totalUnMovedFiles = 0;
    }
}
