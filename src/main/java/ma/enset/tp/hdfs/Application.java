package ma.enset.tp.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {

        Configuration conf=new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:9000");
        FileSystem fs=FileSystem.get(conf);
        Path path=new Path("/file1");
        FSDataInputStream fsip=fs.open(path);
        BufferedReader br=new BufferedReader(new InputStreamReader(fsip));
        String lign=null;
        while((lign=br.readLine())!=null ){
            System.out.println(lign);
            }
        br.close();
        fs.close();
    }
}
