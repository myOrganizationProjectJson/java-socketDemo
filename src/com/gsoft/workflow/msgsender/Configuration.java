package com.gsoft.workflow.msgsender;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** *//**
 * ��ȡproperties�ļ�
 * @author mujj
 *
 */
public class Configuration
{
    private Properties propertie;
    private FileOutputStream outputFile;
    private InputStream is;
    /** *//**
     * ��ʼ��Configuration��
     */
    public Configuration()
    {
        propertie = new Properties();
    }
    
    /** *//**
     * ��ʼ��Configuration��
     * @param filePath Ҫ��ȡ�������ļ���·��+���
     */
    public Configuration(String fileName)
    {
        propertie = new Properties();
        try {
        	is = getClass().getResourceAsStream(fileName);
            propertie.load(is);
            is.close();
        } catch (FileNotFoundException ex) {
            System.out.println("��ȡ�����ļ�--->ʧ�ܣ�- ԭ���ļ�·����������ļ�������");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("װ���ļ�--->ʧ��!");
            ex.printStackTrace();
        }
    }
    
    /** *//**
     * ���غ���õ�key��ֵ
     * @param key ȡ����ֵ�ļ�
     * @return key��ֵ
     */
    public String getValue(String key)
    {
        if(propertie.containsKey(key)){
            String value = propertie.getProperty(key);//�õ�ĳһ���Ե�ֵ
            return value;
        }
        else 
            return "";
    }
    
    /** *//**
     * ���غ���õ�key��ֵ
     * @param fileName properties�ļ���·��+�ļ���
     * @param key ȡ����ֵ�ļ�
     * @return key��ֵ
     */
    public String getValue(String fileName, String key)
    {
        try {
            	String value = "";
            	is = getClass().getResourceAsStream(fileName);
            	propertie.load(is);
            	is.close();
            	if(propertie.containsKey(key)) {
            		value = propertie.getProperty(key);
            	return value;
            }else
                return value;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
    
    /** *//**
     * ���properties�ļ������е�key����ֵ
     */
    public void clear()
    {
        propertie.clear();
    }
    
    /** *//**
     * �ı�����һ��key��ֵ����key������properties�ļ���ʱ��key��ֵ��value����棬
     * ��key������ʱ����key��ֵ��value
     * @param key Ҫ����ļ�
     * @param value Ҫ�����ֵ
     */
    public void setValue(String key, String value)
    {
        propertie.setProperty(key, value);
    }
    
    /** *//**
     * ����ĺ���ļ���ݴ���ָ�����ļ��У����ļ��������Ȳ����ڡ�
     * @param fileName �ļ�·��+�ļ����
     * @param description �Ը��ļ�������
     */
    public void saveFile(String fileName, String description)
    {
        try {
            outputFile = new FileOutputStream(fileName);
            propertie.store(outputFile, description);
            outputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
/*    public static void main(String[] args)
    {
        Configuration rc = new Configuration("st.property");//���·��
        
//      ���¶�ȡproperties�ļ���ֵ
        String sUserName = rc.getValue("username");
        String sPassword = rc.getValue("password");
        String sDomain = rc.getValue("domain");
        
        System.out.println("�û����ǣ� " + sUserName);
        System.out.println("�����ǣ� " + sPassword);
        System.out.println("�����ǣ� " + sDomain);

        Configuration cf = new Configuration();
        String ipp = cf.getValue("st.properties", "ip");
        System.out.println("ipp = " + ipp);
        cf.clear();
        cf.setValue("min", "999");
        cf.setValue("max", "1000");
        cf.saveFile("st.perperties", "test");
        
        Configuration saveCf = new Configuration();
        saveCf.setValue("min", "10");
        saveCf.setValue("max", "1000");
        saveCf.saveFile("st.perperties");
        
    }*/

}