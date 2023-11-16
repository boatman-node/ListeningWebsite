package com;

import com.Mapper.BookInformationMapper;
import com.Mapper.PrivateChatMapper;
import com.Mapper.UserTableMapper;
import com.Service.impl.UserTableImpl;
import com.entity.BookInformation;
import com.entity.UserTable;
import com.enumerate.filetype;
import com.google.gson.Gson;
import com.pool.*;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@SpringBootTest
class ListeningWebsiteApplicationTests {


     @Autowired
    UserTableMapper mapper;
    @Test
    void contextLoads() {
//       List<UserTable> userTables = mapper.selectList(new LambdaQueryWrapper<>());

    }
    @Autowired
    MinioClient minioClient;
    @Value("${minio.bucket}")
    String bucketName;
    @Test
    void contextLoads2() {

        try {
            String s = "imgs/" + UUID.randomUUID() + ".jpeg";
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\86150\\Pictures\\Saved Pictures\\微信图片_20230818105625.jpg");
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object(s) //文件名词
                    .contentType(filetype.image.getValue()) //文件类型
                    .bucket(bucketName) //桶名称  与minio管理界面创建的桶一致即可
                    .stream(fileInputStream,fileInputStream.available(),-1).build();
            minioClient.putObject(putObjectArgs);
                        System.out.println("http://192.168.200.130:9000/"+bucketName+s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidBucketNameException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        }


    }
    @Test
    void contextLoads1() {
        BufferedReader bufferedReader = null;
        try {
            File file = new File("E:\\code area\\Java_Project\\听书网站\\ListeningWebsite\\src\\main\\resources\\test.txt");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Autowired
    UserTableImpl userTable;
  @Autowired
  UserTableMapper mappera;
    @Test
    void contextLoads3() {
                for (int i = 0; i < 10; i++) {
                    String salt = SaltStorage.getSalt();
                    UserTable userTable1 = new UserTable(SaltStorage.getId(), i + "kanghaopeng", SaltedEncryption.encryptWithSalt("kang" + i + "peng", salt), i + "1963470712", i + "kang", "dddddffdaa", new Date(), new Date(), salt, "common");
                    System.out.println(new Gson().toJson(userTable.enrollAccount(userTable1)));
                }
    }

    @Autowired
    BookInformationMapper bookInformationMapper;
    @Test
    void contextLoads10() {
        for (int i = 0; i < 10; i++) {
            String salt = SaltStorage.getSalt();
            BookInformation bookInformation = new BookInformation(SaltStorage.getId(), "船夫", PathTool.GETId(), PathTool.GETId(), 1, 1, "ffsadsa", "javakai", 4, 6, new Date(), "aaaaaaaaaaaafa");
            bookInformationMapper.insert(bookInformation);
//            mapper.insert(new UserTable(new Random().nextLong(),i+"kanghaopeng", SaltedEncryption.encryptWithSalt("kang" + i + "peng", salt),i+"kanghaopeng",i+"kang","dddddffdaa",new Date(),new Date(),salt,"common"));
        }
    }
    @Autowired
    PrivateChatMapper privatw;

    @Autowired
    JWTUtil jwtUtil;

    @Test
    void contextLoads6() {
        String kanghaopeng = jwtUtil.generateToken("kanghaopeng");
        System.out.println(jwtUtil.validateToken(kanghaopeng));
    }

    public static void main(String[] args) {

    }
}
