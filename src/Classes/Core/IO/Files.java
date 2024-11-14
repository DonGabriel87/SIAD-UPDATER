package Classes.Core.IO;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.tree.DefaultMutableTreeNode;
import Classes.Core.App.Cache;
import Classes.Core.Utilities.TimeUtil;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Files {

    /**
     * Método que sirve para obtener la ruta de un directorio seleccionado
     *
     * @return Devuelve la ruta del directorio seleccionado
     */
    public static String getSelectedDirectoryPath() {
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            String filePath = selectedDirectory.getAbsolutePath();
            return filePath;
        } else {
            return "";
        }
    }

    /**
     * Método para llenar el JTree con la estructura de directorios
     *
     * @param tree Recibe la instancia del JTree para modificarla
     * @param path Reciba la ruta del directorio que se quiere conocer la
     * estructura
     */
    public static void fillJTree(javax.swing.JTree tree, String path) {
        File rootFile = new File(path);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootFile.getName());

        createTree(rootFile, root);

        // Asignar el nuevo modelo al JTree
        javax.swing.tree.DefaultTreeModel model = new javax.swing.tree.DefaultTreeModel(root);
        tree.setModel(model);
    }

    /**
     * Método recursivo para crear la estructura del árbol
     *
     * @param fileRoot Recibe la instancia del archivo raíz
     * @param node Recibe la instancia mutable del nodo
     */
    private static void createTree(File fileRoot, DefaultMutableTreeNode node) {
        File[] files = fileRoot.listFiles();
        if (files != null) {
            for (File file : files) {
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
                node.add(childNode);
                if (file.isDirectory()) {
                    createTree(file, childNode); // Llamada recursiva si es un directorio
                }
            }
        }
    }

    /**
     * Método para poder mover los archivos que sean necesarios de una ubicación
     * a otra
     *
     * @param jpbProgresoActualizacion Objeto instanciado para el progreso de
     * las actualizaciones.
     * @param lblEstadoProgreso Objeto instanciado para los mensajes de las
     * actualizaciones.
     */
    public static void moveFiles(javax.swing.JProgressBar jpbProgresoActualizacion, javax.swing.JTextArea lblEstadoProgreso) {
        File sourceDir = new File(Classes.Core.App.Cache.getOripath());
        File targetDir = new File(Classes.Core.App.Cache.getDespath());

        if (!targetDir.exists()) {
            System.err.println("Directorio de destino no existente");
            return;
        }
        // Listamos los subdirectorios de origen y los ordenamos por el número después del guion bajo
        File[] subdirectories = sourceDir.listFiles(File::isDirectory);
        if (subdirectories != null) {
            lblEstadoProgreso.setText("Ordenando directorios");

            Arrays.sort(subdirectories, Comparator.comparingInt(Files::extractNumberFromDirectoryName));

            lblEstadoProgreso.setText("Directorios ordenados");
            jpbProgresoActualizacion.setValue(100);

            // Recorremos los subdirectorios en orden y movemos sus archivos al directorio destino
            for (File dir : subdirectories) {
                File[] files = dir.listFiles(File::isFile);
                jpbProgresoActualizacion.setValue(12);

                int porcentaje;
                int i = 0;

                if (files != null) {
                    for (File file : files) {
                        File targetFile = new File(targetDir, file.getName());
                        lblEstadoProgreso.setText(String.format("Moviendo un total de %s archivos desde:%s hacia:%s", files.length, dir.getPath(), targetDir.getPath()));
                        // Verifica si el archivo existe y elimínalo para reemplazarlo
                        if (targetFile.exists()) {
                            boolean deleted = targetFile.delete();
                            if (!deleted) {
                                System.out.println(String.format("[%s] - No se pudo eliminar el archivo existente: %s", TimeUtil.getCurrentTime(), targetFile.getPath()));
                                continue; // Salta el archivo si no se pudo eliminar
                            }
                        }

                        // Intenta mover el archivo
                        boolean moved = file.renameTo(targetFile);
                        if (moved) {
                            System.out.println(String.format("[%s] - Archivo movido: de %s\\%s a %s", TimeUtil.getCurrentTime(), dir.getPath(), file.getName(), targetFile.getPath()));
                            Cache.setTotalMovedFiles(Cache.getTotalMovedFiles() + 1);
                        } else {
                            System.out.println(String.format("[%s] - Error al mover: %s", TimeUtil.getCurrentTime(), file.getName()));
                            Cache.setTotalUnMovedFiles(Cache.getTotalUnMovedFiles() + 1);
                        }
                        porcentaje = (int) (i++ * 100) / files.length;
                        jpbProgresoActualizacion.setValue(porcentaje);
                    }
                }
            }
        }
    }
    
    /**
     * Valida que los directorios no tengan relación directa o que sean subdirectorios uno del otro
     * @param sourceDirPath
     * Ruta del archivo de origen
     * @param targetDirPath
     * Ruta del archivo de destino
     * @return 
     * Devuelve el resultado de la operación
     */
    public static boolean isValidDestination(String sourceDirPath, String targetDirPath) {
        Path sourcePath = Paths.get(sourceDirPath).normalize();
        Path targetPath = Paths.get(targetDirPath).normalize();

        // Verifica si la ruta de destino está dentro de la ruta de origen
        return !targetPath.startsWith(sourcePath);
    }

    // Método para extraer el número después del guion bajo del nombre del directorio
    private static int extractNumberFromDirectoryName(File dir) {
        String dirName = dir.getName();
        Pattern pattern = Pattern.compile("_(\\d+)$");
        Matcher matcher = pattern.matcher(dirName);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            return Integer.MAX_VALUE; // Si no encuentra un número, lo pone al final de la lista
        }
    }
}
