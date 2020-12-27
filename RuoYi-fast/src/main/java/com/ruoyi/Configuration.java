package com.ruoyi;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${MAC_addr_list}")
    private String MAC_addr_list;
    @Bean
    public void verification() throws UnknownHostException, SocketException  {
        InetAddress ia = InetAddress.getLocalHost();
        String MAC_addr = getLocalMac(ia);
        String[] list = MAC_addr_list.split(",");
        if (!Arrays.asList(list).contains(MAC_addr)){
            System.exit(-1);
        }

    }

    @Bean
    public void verificationDate() throws UnknownHostException, SocketException, ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now=new Date();
        Date verificationDate=df.parse("2021-01-10 00:00:00");
        if (verificationDate.before(now)){
            System.exit(-1);
        }
    }

    private static String getLocalMac(InetAddress ia) throws SocketException {
        //获取网卡，获取地址
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<mac.length; i++) {
            if(i!=0) {
                sb.append("-");
            }
            //字节转换为整数
            int temp = mac[i]&0xff;
            String str = Integer.toHexString(temp);
            if(str.length()==1) {
                sb.append("0"+str);
            }else {
                sb.append(str);
            }
        }
        return sb.toString().toUpperCase();
    }
}
