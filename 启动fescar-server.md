## fescar-server启动
- [github下载fescar-server](https://github.com/alibaba/fescar/releases)
- 启动fescar-server,windows:./bin/fescar-server.bat
- 可能会报 $EXTRA_JVM_ARGUMENTS 找不到主类错误，目前只知道这个是设置 JVM参数的功能，可能是没找到声明。直接把.bat中的$EXTRA_JVM_ARGUMENTS删掉就行