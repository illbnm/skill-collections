package com.dmy.thinking.in.spring.bean.definition;


import com.alibaba.fastjson.JSON;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/**
 * @Author: dongmengyang
 */
public class test {


    public static void main(String[] args) {
        WebDriver driver = getWebDriver();
        try {

            //使用webdriver对象访问w3Cschool
            driver.get("https://www.jd.com/");
            //使用Xpath方法获取页面上一个元素的定位,使用click方法为点击这个元素
            WebElement nickName = null;
            try {
                nickName = driver.findElement(By.xpath("//a[@class='nickname']"));
            } catch (Exception e) {
                driver.findElement(By.xpath("//a[@class='link-login']")).click();
            }
            driver.manage().window().maximize();//最大化窗口
            boolean login = false;
            while (true) {
                try {
                    Thread.sleep(5000);
                    nickName = driver.findElement(By.xpath("//a[@class='nickname']"));
                    if (nickName != null) {
                        System.out.println("登录成功" + nickName.getTagName());
                        login = true;
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            driver.get("https://item.jd.com/100005515829.html#crumb-wrap");
            driver.findElement(By.xpath("//a[@id='InitCartUrl']")).click();


            WebElement element = driver.findElement(By.xpath("//*[@id=\"cart-body\"]/div[2]/div[7]/div/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/span[2]"));



            driver.get("https://item.jd.com/100005515829.html#crumb-wrap");

        } catch (Exception e) {
           e.printStackTrace();
        }finally {
            driver.close();
        }
//        driver.navigate().back();//控制页面后退
//
//        driver.navigate().forward();//控制浏览器前进
//
//        driver.navigate().refresh();//控制页面刷新
//
//        driver.get("https://www.baidu.com/");//跳转到百度
//
//        WebElement search_text = driver.findElement(By.id("kw"));
//        //定义一个webelement元素名为search_text与页面id为kw的元素进行挂钩
//        search_text.sendKeys("W3Cschool");
//        try {
//            Thread.sleep(2000);//使用sleep方法可以暂时挂起线程，但必须要用try-catch语句包裹
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //使用search的sendkeys向与其挂钩的元素发送字符串“java”
//        search_text.clear();
//        //清空这个元素的模拟文本
//
//        WebElement search_setting = driver.findElement(By.xpath("//*[@id='u']/a[2]"));
//        //使用Xpath定位到百度搜索页面的设置按钮
//        Actions action = new Actions(driver);//新建一个action对象
//        action.clickAndHold(search_setting).perform();//使用action对象的clickAndHold可以实现在目标上进行悬停操作
//        //一定要加perform()才能执行代码
//        action.contextClick(search_setting).perform();//鼠标右键点击目标对象
//        action.doubleClick(search_setting).perform();//鼠标双击目标对象
//
//        driver.quit();//关闭浏览器对象
    }

    private static WebDriver getWebDriver() {
        //如果报错说找不到Chromedriver的话（即驱动没有配进环境变量），就使用如下代码
        System.setProperty("webdriver.chrome.driver", "E:\\Release\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //读取用户参数，XX代表当前用户
        options.addArguments("--user-data-dir=C:\\Users\\35890\\AppData\\Local\\Google\\Chrome\\User Data");
        //创建一个webdriver对象
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }


}
