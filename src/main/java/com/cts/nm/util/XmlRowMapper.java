package com.cts.nm.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class XmlRowMapper implements RowMapper<byte[]> {

    public byte[] mapRow(ResultSet rs, int rowNum) throws SQLException {
         Blob column = rs.getBlob("NM_DETAILS");
         InputStream binaryInput = rs.getBinaryStream("NM_DETAILS");
         FileOutputStream fileoutputstream;
		try {
			fileoutputstream = new FileOutputStream("C:/Users/735081/Desktop/NMJML/BlobTestFiles/Destination/Blobfile.xml");
		
         int i;
         while((i = binaryInput.read()) != -1) 
             fileoutputstream.write(i);
         fileoutputstream.close();
         System.out.println(column);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return column.getBytes(1, (int) column.length());
    }
}
