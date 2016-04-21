# GreenDAO_Demo
参考资料<br>
http://www.open-open.com/lib/view/open1438065400878.html<br>
http://blog.csdn.net/h3c4lenovo/article/details/43566169<br>
http://my.oschina.net/cheneywangc/blog/196354<br>

这里只需要关注一个问题，就是如果数据库要升级，这里是修改代码后全量重新创建。<br>

假设要给user表增加一个”age”属性，并且增加school表的做法是：<br>

把数据库版本号修改为2<br>

在initUserBean方法中加入userBean.addStringProperty("age");<br>

新建initSchoolBean方法<br>

当明白这个文件的写法之后就要运行这个文件了，进到AndroidStudio的Gradel面板中执行run任务。<br>

执行完成之后就会在java-gen文件夹下生成需要的代码了。<br>
