package com.biprom.amcal.amcalpompen.GridFS;

import com.biprom.amcal.amcalpompen.Entities.DetailTicket;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class GridFSService implements GridFsOperations {


    DBObject metaData = new BasicDBObject(  );
    GridFsTemplate gridFsTemplate;
    String imageField;
    List<String>idPictures = new ArrayList<>(  );

    @Autowired
    public GridFSService(GridFsTemplate gridFsTemplate)  {

       this.gridFsTemplate = gridFsTemplate;


    }

    public void storeFileToMongoDB (String filename, String meta1, String meta2, String newFile, DetailTicket detailTicket){

        File file = new File( filename );
        FileInputStream inputStream = null;


        try {
            System.out.println( "storeFileToMongoDB is started" );
            inputStream = new FileInputStream( file );

            metaData.put( meta1, meta2 );
            imageField = gridFsTemplate.store( inputStream, newFile, "image/png",metaData ).getId().toString();
            idPictures.add( imageField );
            detailTicket.setPictureList( idPictures );

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

    }

    public void findFilesForDetailTicket (DetailTicket detailTicket){

            System.out.println( "detailticket :" + detailTicket.getOmschrijvingPomp()  );

            for (String str : detailTicket.getPictureList()){

                List<GridFSDBFile> result = gridFsTemplate.find( new Query(Criteria.where("_id").is(str)));

                for (GridFSDBFile file : result) {
                    try {
                        System.out.println(file.getFilename());
                        System.out.println(file.getContentType());

                        //save as another image
                        file.writeTo("/Users/bramvandenberghe/recPicFromDB/newbie.jpeg");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

            }




    }


    @Override
    public GridFSFile store(InputStream inputStream, String s) {
        return null;
    }

    @Override
    public GridFSFile store(InputStream inputStream, Object o) {
        return null;
    }

    @Override
    public GridFSFile store(InputStream inputStream, DBObject dbObject) {
        return null;
    }

    @Override
    public GridFSFile store(InputStream inputStream, String s, String s1) {
        return null;
    }

    @Override
    public GridFSFile store(InputStream inputStream, String s, Object o) {
        return null;
    }

    @Override
    public GridFSFile store(InputStream inputStream, String s, String s1, Object o) {
        return null;
    }

    @Override
    public GridFSFile store(InputStream inputStream, String s, DBObject dbObject) {
        return null;
    }

    @Override
    public GridFSFile store(InputStream inputStream, String s, String s1, DBObject dbObject) {
        return null;
    }

    @Override
    public List<GridFSDBFile> find(Query query) {
        return null;
    }

    @Override
    public GridFSDBFile findOne(Query query) {
        return null;
    }

    @Override
    public void delete(Query query) {

    }

    @Override
    public GridFsResource getResource(String s) {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public GridFsResource[] getResources(String s) {
        return new GridFsResource[0];
    }
}
