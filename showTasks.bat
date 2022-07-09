call %CATALINA_HOME%\bin\startup.bat
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo Cannot start server
goto fail

:runbrowser
call start chrome http://localhost:8080/crud/v1/tasks
echo.
echo Cannot start browser
goto fail
