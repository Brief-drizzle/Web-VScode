package servlet;

/**
 * @author Administrator
 *
 */

import java.util.*;



/**
* 人脸搜索
*/
public class faceSearch {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static List<String> search(String image) {
    	List<String> list = new ArrayList<String>();
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            Map<String, Object> map = new HashMap<>();
            String substring = image.substring(image.indexOf(",")+1, image.length());
            map.put("image", substring); //图片base64数据
            map.put("liveness_control", "NONE");  //活体检测控制无
            map.put("group_id_list", "zzz");  //指定用户组group 人脸库总已经存在的用户组
            map.put("image_type", "BASE64");     //图片类型，这里转化过的base64
            map.put("quality_control", "LOW");   //图片质量控制

            String param = GsonUtils.toJson(map);
            AuthService auth = new AuthService();
            String accessToken = auth.getAuth();
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。

            String result = HttpUtil.post(url, accessToken, "application/json", param);

            String score = result.split(",")[9].split(":")[1];
            String user_id = result.split(",")[7].split(":")[1];
            String graoup_id = result.split(",")[6].split(":")[2];
            
            System.out.println("graoup_id=="+graoup_id);	
            System.out.println("user_id=="+user_id);	
           	
            System.out.println("检测=="+result);
            System.out.println("检测分数=="+score);
            list.add(graoup_id);list.add(user_id);list.add(score);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}