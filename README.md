# Acerca del proyecto
## Nombre
SIAD-UPDATER

## Descripción del proyecto
SIAD-UPDATER es un proyecto open-source que tiene la finalidad de automatizar el proceso de actualización del software SIAD propietario de CFE, 
todo con el fin de hacer esta tarea tan tediosa más sencilla.

## Ejecutando el proyecto
Para poder dar inicio con la ejecución del proyecto es importante considerar que esta herramienta requiere **privilegios de administrador**, de otra forma no podremos lograr compilarlo a menos de que comentemos momentáneamente el método **isProgramRunningWithAdminPrivileges()** ubicado en el archivo main.java, de ser el caso que se haga esta modificación, ignoráremos la verificación de que el proceso se esté corriendo con privilegios elevados.

Si elegimos este camino no se asegura el éxito de las tareas de movimientos de archivos a nivel raíz del disco, por lo que es recomendable hacerlo de la siguiente manera: 
Para lograr ejecutarlo de manera correcta es posible lograrlo de varias maneras, pero, para este caso mostraré dos formas de hacerlo.

### Primer forma
En caso de que se te posibilite, puedes hacer clic derecho sobre el archivo .jar  propiedades -> General -> Avanzado -> Ejecutar como administrador.
En mi caso en Windows 11 Pro versión 23H2 no me da la opción de hacerlo de esta manera por lo que recomiendo hacerla de la **segunda forma** en caso de
que tengan el mismo problema.

### Segunda forma
La segunda forma parecerá un poco más compleja pero es más sencillo de lo que parece, para iniciar, deberemos de colocarnos sobre el archivo compilado del proyecto, abrir un bloc de notas, colocar el siguiente texto:

```
@echo off
:: Dirección de la herramienta SIAD-UPDATER
set "JAR_FILE=%~dp0SIAD-UPDATER.jar"

:: Comprueba si el script se está ejecutando como administrador
net session >nul 2>&1
if %errorlevel% neq 0 (
    echo Solicitando permisos de administrador...
    powershell -Command "Start-Process '%0' -Verb RunAs"
    exit /b
)

:: Bienvenida
echo Bienvenido a la herramienta SIAD-UPDATER

:: Ejecuta el archivo JAR con permisos de administrador
echo Ejecutando %JAR_FILE% con permisos de administrador... - %date% %time%
java -jar "%JAR_FILE%"
pause
```

Posterior a ello lo guardaremos con el nombre que mas nos guste, pero con el formato .bat de este modo estaría listo para usarse SIAD-UPDATER.

> [!TIP]
> Es recomendable crear un acceso directo a ese archivo .bat que has creado y colocarlo donde más gustes.

## Otras consideraciones

> [!IMPORTANT]
> Requisitos del sistema
> - Hardware
>   
>   - 20 MB libres de espacio
>  
> - Software
> 
>   - Java (recomendable su última versión)

## Autor
Jhovany J.
```
   \    /\
    )  ( ')    <-  (MEOW)
    (  /  )
     \(__)| 
```