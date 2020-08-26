package com.dbl.simple.base.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dbl.simple.base.bean.WeatherBean;
import com.dbl.simple.utils.httputils.HttpUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * descrription:天气查询
 * <p>
 * Create by DbL on 2020/8/26 0026 23:44
 */
@Service
public class WeatherService {
    private String weatherUrl = "http://wthrcdn.etouch.cn/weather_mini?city=";
    /**
     * 通过城市名称获取该城市的天气信息
     */
    public  String GetWeatherData(String cityname) {
        return GetWeather(HttpUtils.getRequest(weatherUrl + cityname)).toString();
    }

    /**
     * 将JSON格式数据进行解析 ，返回一个weather对象
     */
    public WeatherBean GetWeather(String WeatherBeanbyJson){
        JSONObject dataOfJson = JSONObject.parseObject(WeatherBeanbyJson);   // json天气数据
        if(dataOfJson.getIntValue("status") != 1000){
            return null;
        }
        // 创建WeatherBean对象，提取所需的天气信息
        WeatherBean WeatherBean = new WeatherBean();

        // 获取当前日期：日期、星期
        Calendar cal = Calendar.getInstance();    							     // Calendar类的实例化
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");  // 时间的格式化
        WeatherBean.setDate(sdf1.format(cal.getTime()));                // 时间
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE");
        WeatherBean.setWeek(sdf2.format(cal.getTime()));                // 星期

        // 从json数据中提取数据：城市、温度、小提醒
        dataOfJson = JSONObject.parseObject(dataOfJson.getString("data"));
        WeatherBean.setCityname(dataOfJson.getString("city"));            // 城市
        WeatherBean.setTemp(dataOfJson.getString("wendu"));               // 温度
        WeatherBean.setTips(dataOfJson.getString("ganmao"));              // 小提示

        // 获取今天的天气预报信息：最高温度、最低温度、天气
        JSONArray forecast = dataOfJson.getJSONArray("forecast");
        JSONObject result = forecast.getJSONObject(0);
        WeatherBean.setHighTemp(result.getString("high").substring(2));   // 最高气温
        WeatherBean.setLowTemp(result.getString("low").substring(2));     // 最低气温
        WeatherBean.setWeather(result.getString("type"));                 // 天气

        return WeatherBean;
    }
}
