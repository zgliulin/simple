package com.dbl.simple.base.bean;

/**
 * descrription:
 * <p>
 * Create by DbL on 2020/8/26 0026 23:42
 */
public class WeatherBean {
    private String date; // 时间
    private String week; // 星期
    private String lunar; // 农历时间
    private String cityname; // 城市名
    private String weather; // 天气
    private String temp; // 当前温度
    private String highTemp; // 最低温度
    private String lowTemp; // 当前温度
    private String tips; // 小提示

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "date='" + date + '\'' +
                ", week='" + week + '\'' +
                ", lunar='" + lunar + '\'' +
                ", cityname='" + cityname + '\'' +
                ", weather='" + weather + '\'' +
                ", temp='" + temp + '\'' +
                ", highTemp='" + highTemp + '\'' +
                ", lowTemp='" + lowTemp + '\'' +
                ", tips='" + tips + '\'' +
                '}';
    }
}
