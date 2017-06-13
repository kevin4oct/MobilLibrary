package com.hebth.mobilelibrary.beans;

import com.hebth.mobilelibrary.ui.main.fragments.ebook.net.ReadCarouselParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * Created by hebth on 2017-06-12.
 * read轮播图的s实体类
 */

@HttpResponse(parser = ReadCarouselParser.class)
public class ReadCarouselBean {


    /**
     * data : [{"ranknum":"1","webUrl":"http://www.591ebooks.com/","organId":"sheguan","fileUrl":"http://101.201.114.210/591/ebooks/group1/M00/03/5A/Zcl0llkQJ2eAD0wZAABQfiTcnv0906.jpg","location":"0","id":"f334f77d-116e-4f9c-bd1d-21d85e54d757","imageType":"1"},{"ranknum":"2","webUrl":"http://www.591ebooks.com/","organId":"sheguan","fileUrl":"http://101.201.114.210/591/ebooks/group2/M00/03/39/Zcl001j4jDmADrwIAAqpQsgbKSs302.png","location":"0","id":"82832194-05e2-47a4-8c66-10452cd4c7ab","imageType":"1"},{"ranknum":"3","webUrl":"http://www.591ebooks.com/","organId":"sheguan","fileUrl":"http://101.201.114.210/591/ebooks/group2/M00/03/3B/Zcl0zlj4jESAC49sAAkTMpQEsls021.png","location":"0","id":"2bc5b04d-3103-43cc-b386-112ff5a6bb8e","imageType":"1"},{"ranknum":"4","webUrl":"http://www.591ebooks.com/","organId":"sheguan","fileUrl":"http://101.201.114.210/591/ebooks/group2/M00/03/39/Zcl001j4jE6ABd5OAAb9aJCUdq4442.png","location":"0","id":"4c42f94f-52b6-40b8-833e-f82aa6b64ffe","imageType":"1"}]
     * status : 1
     */

    private String status;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ranknum : 1
         * webUrl : http://www.591ebooks.com/
         * organId : sheguan
         * fileUrl : http://101.201.114.210/591/ebooks/group1/M00/03/5A/Zcl0llkQJ2eAD0wZAABQfiTcnv0906.jpg
         * location : 0
         * id : f334f77d-116e-4f9c-bd1d-21d85e54d757
         * imageType : 1
         */

        private String ranknum;
        private String webUrl;
        private String organId;
        private String fileUrl;
        private String location;
        private String id;
        private String imageType;

        public String getRanknum() {
            return ranknum;
        }

        public void setRanknum(String ranknum) {
            this.ranknum = ranknum;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public String getOrganId() {
            return organId;
        }

        public void setOrganId(String organId) {
            this.organId = organId;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImageType() {
            return imageType;
        }

        public void setImageType(String imageType) {
            this.imageType = imageType;
        }
    }
}
