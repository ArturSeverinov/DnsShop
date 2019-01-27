package ru.dnsShop;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


/**
 * Ловил ElementNotVisibleException
 * научиться писать короткие XPath
 * Научиться писать ожидание элемента на странице
 * XPath работает быстрее CSS
 */

public class DnsShop extends BaseForDnsShop {


    @Test
    public void specificationsCompareTest() throws InterruptedException {

        driver.get("https://www.dns-shop.ru/");
        //Создаём два стрингбилдера для сбора характеристик системного блока
        StringBuilder specificationsFirst = new StringBuilder();
        StringBuilder specificationsSecond = new StringBuilder();
        String specFirstString;
        String specSecondString;
        Logger log = Logger.getLogger("DnsShop");

        log.info("Открытие вкладки Компьютеры и перефирия");
        driver.findElement(By.xpath("//*[@id=\"menu-catalog\"]/li[2]/a/span[3]")).click();

        log.info("Открытие вкладки Компьютерные системы");
        driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/a[1]/div[2]/div[1]/span")).click();

        log.info("Открытие вкладки Системные блоки");
        driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/a[1]/div[2]/div[1]/span")).click();

        log.info("Выбор категории сортировки товара");
        driver.findElement(By.xpath("//*[@id=\"sort-filter\"]/div[1]/div/button/span[2]")).click();

        log.info("Выбор категории цена по убыванию");
        driver.findElement(By.xpath("//*[@id=\"sort-filter\"]/div[1]/div/ul/li[2]/a")).click();

        //Без слипа возникала ошибка org.openqa.selenium.WebDriverException: unknown error: Element is not clickable at point... Нужно заменить ожиданием элемента ан странице, когда узнаю как)
        log.info("Усыпляется поток на 2 секунды чтобы на странице появились все элементы");
        Thread.sleep(2000);

        log.info("Выбор четвертой позиции сверху сверху");
        driver.findElement(By.xpath("//*[@id=\"catalog-items-page\"]/div[6]/div[5]/div[1]/div[1]/div[4]/div/div[1]/div[2]/a/h3")).click();

        log.info("Вычитывается название системного блока");
        specificationsFirst.append("Название: " + driver.findElement(By.xpath("//*[@id=\"product-page\"]/h1")).getText() + "\n");

        log.info("Открываются характеристики");
        driver.findElement(By.xpath("//*[@id=\"item-tabs-block\"]/ul/li[2]/a[1]")).click();
        log.info("Вычитывается цена");
        specificationsFirst.append("Цена: " + driver.findElement(By.xpath("//*[@id=\"product-page\"]/div[4]/div[2]/div/div[3]/div[1]/div[1]/div/div/div/div[2]/span")).getText() + "\n");
        log.info("Вычитывается гарантия");
        specificationsFirst.append("Гарантия: " + driver.findElement(By.xpath("//*[@id=\"product-page\"]/div[4]/div[2]/div/div[5]/div[1]/p[2]/span[2]")).getText() + "\n");
        log.info("Вычитывается операционная система");
        specificationsFirst.append("Операционная система: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[5]/td[2]")).getText() + "\n");
        log.info("Вычитывается модель процессора");
        specificationsFirst.append("Модель процессора: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[7]/td[2]")).getText() + "\n");
        log.info("Вычитывается кол-во ядер");
        specificationsFirst.append("Количество ядер: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[8]/td[2]")).getText() + "\n");
        log.info("Вычитывается тактовая частота");
        specificationsFirst.append("Тактовая частота: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[9]/td[2]")).getText() + "\n");
        log.info("Вычитывается модель видеокарты");
        specificationsFirst.append("Модель видеокарты: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[16]/td[2]")).getText() + "\n");
        log.info("Вычитывается объём видеопамяти");
        specificationsFirst.append("Объём видеопамяти: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[19]/td[2]")).getText() + "\n");
        log.info("Вычитывается размер оперативной памяти");
        specificationsFirst.append("Размер оперативной памяти: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[22]/td[2]")).getText() + "\n");
        log.info("Вычитывается тип оперативной памяти");
        specificationsFirst.append("Тип оперативной памяти: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[21]/td[2]")).getText() + "\n");
        log.info("Вычиытвается объём SSD");
        specificationsFirst.append("Объём SSD: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[25]/td[2]")).getText() + "\n");

        specFirstString = specificationsFirst.toString();

        //Переходим на главную страницу
        driver.findElement(By.xpath("//*[@id=\"header-search\"]/div/div[1]/a")).click();

        //открытие Компьютеры и перефирия
        driver.findElement(By.xpath("//*[@id=\"menu-catalog\"]/li[2]/a/span[3]")).click();

        //Компьютерные системы
        driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/a[1]/div[2]/div[1]/span")).click();

        //Системные блоки
        driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/a[1]/div[2]/div[1]/span")).click();

        //Проверяем как выставлена сортировка, если по убыванию, меняем по возрастанию.
        if (driver.findElement(By.xpath("//*[@id=\"sort-filter\"]/div[1]/div/button/span[2]")).getText().equals("по убыванию цены")) {
            //Категория сортировки
            driver.findElement(By.xpath("//*[@id=\"sort-filter\"]/div[1]/div/button/span[2]")).click();
            //Выставляем категорию по возрастанию
            driver.findElement(By.xpath("//*[@id=\"sort-filter\"]/div[1]/div/ul/li[1]/a")).click();
        }

        int down = 2;
        log.info("Усыпляется поток на 2 секунды чтобы на странице появились все элементы");
        Thread.sleep(2000);

        //Переход в конец списка
        while (driver.findElements(By.xpath("//*[@id=\"catalog-items-page\"]/div[6]/div[5]/div[1]/div[" + down + "]/a")).size() > 0) {
            driver.findElement(By.xpath("//*[@id=\"catalog-items-page\"]/div[6]/div[5]/div[1]/div[" + down + "]/a")).click();
            down += 2;
            Thread.sleep(2000);
        }

        log.info("Усыпляется поток на 2 секунды чтобы на странице появились все элементы");
        Thread.sleep(2000);

        //Выбираем 4й системный блок снизу списка
        driver.findElement(By.xpath("//*[@id=\"catalog-items-page\"]/div[6]/div[5]/div[1]/div[23]/div[19]/div/div[1]/div[2]/a/h3")).click();

        //Название системного блока
        specificationsSecond.append("Название: " + driver.findElement(By.xpath("//*[@id=\"product-page\"]/h1")).getText() + "\n");
        //Цена
        specificationsSecond.append("Цена: " + driver.findElement(By.xpath("//*[@id=\"product-page\"]/div[4]/div[2]/div/div[3]/div[1]/div[1]/div/div/div/div[2]/span")).getText() + "\n");
        //Гарантия
        specificationsSecond.append("Гарантия: " + driver.findElement(By.xpath("//*[@id=\"product-page\"]/div[4]/div[2]/div/div[5]/div[1]/p[2]/span[2]")).getText() + "\n");
        //Открываем характеристики
        driver.findElement(By.xpath("//*[@id=\"item-tabs-block\"]/ul/li[2]/a[1]")).click();
        //Операционнас система
        specificationsSecond.append("Операционная система: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[5]/td[2]")).getText() + "\n");
        //Модель процессора
        specificationsSecond.append("Модель процессора: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[7]/td[2]")).getText() + "\n");
        //Кол-во ядер
        specificationsSecond.append("Количество ядер: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[8]/td[2]")).getText() + "\n");
        //Тактовая частота
        specificationsSecond.append("Тактовая частота: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[9]/td[2]")).getText() + "\n");
        //Модель видеокарты
        specificationsSecond.append("Модель видеокарты: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[16]/td[2]")).getText() + "\n");
        //Объём видеопамяти
        specificationsSecond.append("Объём видеопамяти: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[19]/td[2]")).getText() + "\n");
        //Размер оперативной памяти
        specificationsSecond.append("Размер оперативной памяти: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[22]/td[2]")).getText() + "\n");
        //Тип оперативной памяти
        specificationsSecond.append("Тип оперативной памяти: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[21]/td[2]")).getText() + "\n");
        //Объем SSD
        specificationsSecond.append("Объём SSD: " + driver.findElement(By.xpath("//*[@id=\"characteristics\"]/div[2]/table/tbody/tr[25]/td[2]")).getText() + "\n");

        specSecondString = specificationsSecond.toString();

        System.out.println(specificationsFirst);
        System.out.println(specificationsSecond);

        Assert.assertTrue(specFirstString.equals(specSecondString));


    }


}
