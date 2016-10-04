package beauty.wsh.com.growdemo.applyaar;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public interface aar使用说明 {
    /**
     * aar生成：
     * 1.新建的module或者library；
     * 2.Build --> Rebuild Project
     * 3.在module或者library中，build --> outputs --> aar --> aar文件。
     * 
     * aar使用：
     * 1.把aar文件放入相应module的libs文件夹下；
     * 2.在该module模块的build.gradle文件中，android{}域内，添加如下内容：
     *      repositories{
     *          flatDir{
     *              dirs 'libs'
     *          }
     *      }
     * 3.在该module模块的build.gradle文件中，dependencies{}域内添加如下内容：
     *      compile(name:'aar_name',ext:'aar')
     *      备注：前一个是aar文件名，后一个是aar文件扩展名。
     *      （可以修改aar文件名，能成功调用）
     */
}
