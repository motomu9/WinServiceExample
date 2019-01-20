set EXEC_DIR=%~dp0
echo %EXEC_DIR%
set INSTALL_PATH=%EXEC_DIR%ServiceLauncher.exe
set CLASSPATH=%EXEC_DIR%ServiceLauncher.jar;
set JVM_PATH="C:\Program Files\Java\jre1.8.0_191\bin\server\jvm.dll"


ServiceLauncher //IS//ServiceLauncher --DisplayName="ServiceLauncher" --Install=%INSTALL_PATH% --Startup=auto --Jvm=%JVM_PATH% --StartMode=java --StopMode=java --Classpath=%CLASSPATH% --StartClass=example.ServiceLauncher --StartMethod=startService --StopClass=example.ServiceLauncher --StopMethod=stopService --LogPath=%EXEC_DIR% --LogLevel=DEBUG --StdOutput=auto --StdError=auto
pause
