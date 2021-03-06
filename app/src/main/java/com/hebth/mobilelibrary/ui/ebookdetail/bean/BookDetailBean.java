package com.hebth.mobilelibrary.ui.ebookdetail.bean;

import com.hebth.mobilelibrary.ui.ebookdetail.net.DetailParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * Created by hebth on 2017-06-14.
 * 电子书详情的实体类
 */
@HttpResponse(parser = DetailParser.class)
public class BookDetailBean {

    /**
     * data1 : {"id":"de5102c61e7911e7bd1f00163e160aa8","bookTarget":{"id":null,"bookId":"de5102c61e7911e7bd1f00163e160aa8","electronic":null,"rightStartDate":null,"rightEndDate":null,"rightFromId":null,"rightFromName":null,"count":null,"reponsibilityEdition":null,"charNumber":null,"cano":null,"ano":null,"other1":null,"other2":null,"other3":null,"other4":null,"other5":null,"buyerId":null,"buyerName":null,"buyDate":null,"createUserId":null,"createUserName":null,"createDate":null,"checkerId":null,"checkerName":null,"checkFlag":null,"checkNotes":null,"flagEnd":null,"fileSize":null,"modifyUserId":null,"modifyUserName":null,"modifyDate":null},"libraryOrganization":null,"bookName":"荷塘月色","bookAuthor":"朱自清","press":"万卷出版公司","publishDate":1343750400000,"publishDatestr":null,"bookPrice":19.8,"aboutAuthor":null,"isbn":"978-7-5470-2368-6","classificationNumber":"I266","subjectTerm":null,"bookLanguage":null,"bookEdition":null,"translationAnnotation":null,"bookSubtitle":null,"subjectClassificationNumbers":null,"winningNumberClassification":null,"description":"本书是一本电话销售方法的原创读本。《电话销售28堂实战训练课》凝聚着一位成功销售人士的推销心经。《电话销售28堂实战训练课》通过原因分析、解决方法、故事导入的三种形式把电话推销方法融入其中，内容简洁、通俗、易懂。","bindingLayout":null,"uploadDate":null,"status":1,"bookType":null,"organId":null,"country":null,"area":null,"physicalAttr":null,"bookNamePY":null,"generalDataId":null,"anotherAuthor":null,"parallelTitle":null,"translator":null,"volumesName":null,"volumesNo":null,"editionState":null,"city":null,"pages":null,"chart":null,"size":null,"attachment":null,"seriesName":null,"seriesNamePy":null,"seriesAuthor":null,"generalNotes":null,"publicationNotes":null,"responsibilityNotes":null,"userNotes":null,"parallelTitleProper":null,"pTPLanguage":null,"personalSubject":null,"corporateSubject":null,"titleSubject":null,"topicalSubject":null,"geographicalSubject":null,"uncontrolledSubject":null,"lccas":null,"air":null,"airPy":null,"sir":null,"sirPy":null,"pir":null,"originatingSource":null,"deleteFlag":null,"shelveDate":null,"bookStarLevel":"1","bookFiles":[{"id":null,"bookId":null,"origName":"978-7-5470-2368-6_de5102c61e7911e7bd1f00163e160aa8.epub","fileSize":206947,"filePath":"group1/M00/03/4F/Zcl0lljsinaAKUE1AAMoY1ys97Q53.epub","fileExt":"epub","tableContent":"封面\n版权信息\n序言\n感悟\n《忆》跋\n荷塘月色\n春\n买书\n故人\n我是扬州人\n教育家的夏丏尊先生\n阿河\n给亡妇\n我所见的叶圣陶\n踪迹\n温州的踪迹\n旅行杂记\n重庆行记\n蒙自杂记\n思索\n航船中的文明\n白种人\u2014\u2014上帝的骄子\n沉默\n论诚意\n论废话\n论气节\n伦敦杂记\n三家书店\n文人宅\n博物院\n公园\n加尔东尼市场\n吃的\n乞丐\n圣诞节\n房东太太","attachType":1,"isMark":null,"isUsing":null}],"bookPictures":[{"id":null,"bookId":null,"origName":"978-7-5470-2368-6_de5102c61e7911e7bd1f00163e160aa8.jpg","fileSize":53182,"filePath":"group1/M00/03/4F/Zcl0d1jsinuAdeoHAAAqjrPNNrI876.jpg","fileExt":"jpg","tableContent":null,"attachType":2,"isMark":null,"isUsing":null}],"specialColumnId":null}
     */

    private Data1Bean data1;

    public Data1Bean getData1() {
        return data1;
    }

    public void setData1(Data1Bean data1) {
        this.data1 = data1;
    }

    public static class Data1Bean {
        /**
         * id : de5102c61e7911e7bd1f00163e160aa8
         * bookTarget : {"id":null,"bookId":"de5102c61e7911e7bd1f00163e160aa8","electronic":null,"rightStartDate":null,"rightEndDate":null,"rightFromId":null,"rightFromName":null,"count":null,"reponsibilityEdition":null,"charNumber":null,"cano":null,"ano":null,"other1":null,"other2":null,"other3":null,"other4":null,"other5":null,"buyerId":null,"buyerName":null,"buyDate":null,"createUserId":null,"createUserName":null,"createDate":null,"checkerId":null,"checkerName":null,"checkFlag":null,"checkNotes":null,"flagEnd":null,"fileSize":null,"modifyUserId":null,"modifyUserName":null,"modifyDate":null}
         * libraryOrganization : null
         * bookName : 荷塘月色
         * bookAuthor : 朱自清
         * press : 万卷出版公司
         * publishDate : 1343750400000
         * publishDatestr : null
         * bookPrice : 19.8
         * aboutAuthor : null
         * isbn : 978-7-5470-2368-6
         * classificationNumber : I266
         * subjectTerm : null
         * bookLanguage : null
         * bookEdition : null
         * translationAnnotation : null
         * bookSubtitle : null
         * subjectClassificationNumbers : null
         * winningNumberClassification : null
         * description : 本书是一本电话销售方法的原创读本。《电话销售28堂实战训练课》凝聚着一位成功销售人士的推销心经。《电话销售28堂实战训练课》通过原因分析、解决方法、故事导入的三种形式把电话推销方法融入其中，内容简洁、通俗、易懂。
         * bindingLayout : null
         * uploadDate : null
         * status : 1
         * bookType : null
         * organId : null
         * country : null
         * area : null
         * physicalAttr : null
         * bookNamePY : null
         * generalDataId : null
         * anotherAuthor : null
         * parallelTitle : null
         * translator : null
         * volumesName : null
         * volumesNo : null
         * editionState : null
         * city : null
         * pages : null
         * chart : null
         * size : null
         * attachment : null
         * seriesName : null
         * seriesNamePy : null
         * seriesAuthor : null
         * generalNotes : null
         * publicationNotes : null
         * responsibilityNotes : null
         * userNotes : null
         * parallelTitleProper : null
         * pTPLanguage : null
         * personalSubject : null
         * corporateSubject : null
         * titleSubject : null
         * topicalSubject : null
         * geographicalSubject : null
         * uncontrolledSubject : null
         * lccas : null
         * air : null
         * airPy : null
         * sir : null
         * sirPy : null
         * pir : null
         * originatingSource : null
         * deleteFlag : null
         * shelveDate : null
         * bookStarLevel : 1
         * bookFiles : [{"id":null,"bookId":null,"origName":"978-7-5470-2368-6_de5102c61e7911e7bd1f00163e160aa8.epub","fileSize":206947,"filePath":"group1/M00/03/4F/Zcl0lljsinaAKUE1AAMoY1ys97Q53.epub","fileExt":"epub","tableContent":"封面\n版权信息\n序言\n感悟\n《忆》跋\n荷塘月色\n春\n买书\n故人\n我是扬州人\n教育家的夏丏尊先生\n阿河\n给亡妇\n我所见的叶圣陶\n踪迹\n温州的踪迹\n旅行杂记\n重庆行记\n蒙自杂记\n思索\n航船中的文明\n白种人\u2014\u2014上帝的骄子\n沉默\n论诚意\n论废话\n论气节\n伦敦杂记\n三家书店\n文人宅\n博物院\n公园\n加尔东尼市场\n吃的\n乞丐\n圣诞节\n房东太太","attachType":1,"isMark":null,"isUsing":null}]
         * bookPictures : [{"id":null,"bookId":null,"origName":"978-7-5470-2368-6_de5102c61e7911e7bd1f00163e160aa8.jpg","fileSize":53182,"filePath":"group1/M00/03/4F/Zcl0d1jsinuAdeoHAAAqjrPNNrI876.jpg","fileExt":"jpg","tableContent":null,"attachType":2,"isMark":null,"isUsing":null}]
         * specialColumnId : null
         */

        private String id;
        private BookTargetBean bookTarget;
        private Object libraryOrganization;
        private String bookName;
        private String bookAuthor;
        private String press;
        private long publishDate;
        private Object publishDatestr;
        private double bookPrice;
        private Object aboutAuthor;
        private String isbn;
        private String classificationNumber;
        private Object subjectTerm;
        private Object bookLanguage;
        private Object bookEdition;
        private Object translationAnnotation;
        private Object bookSubtitle;
        private Object subjectClassificationNumbers;
        private Object winningNumberClassification;
        private String description;
        private Object bindingLayout;
        private Object uploadDate;
        private int status;
        private Object bookType;
        private Object organId;
        private Object country;
        private Object area;
        private Object physicalAttr;
        private Object bookNamePY;
        private Object generalDataId;
        private Object anotherAuthor;
        private Object parallelTitle;
        private Object translator;
        private Object volumesName;
        private Object volumesNo;
        private Object editionState;
        private Object city;
        private Object pages;
        private Object chart;
        private Object size;
        private Object attachment;
        private Object seriesName;
        private Object seriesNamePy;
        private Object seriesAuthor;
        private Object generalNotes;
        private Object publicationNotes;
        private Object responsibilityNotes;
        private Object userNotes;
        private Object parallelTitleProper;
        private Object pTPLanguage;
        private Object personalSubject;
        private Object corporateSubject;
        private Object titleSubject;
        private Object topicalSubject;
        private Object geographicalSubject;
        private Object uncontrolledSubject;
        private Object lccas;
        private Object air;
        private Object airPy;
        private Object sir;
        private Object sirPy;
        private Object pir;
        private Object originatingSource;
        private Object deleteFlag;
        private Object shelveDate;
        private String bookStarLevel;
        private Object specialColumnId;
        private List<BookFilesBean> bookFiles;
        private List<BookPicturesBean> bookPictures;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public BookTargetBean getBookTarget() {
            return bookTarget;
        }

        public void setBookTarget(BookTargetBean bookTarget) {
            this.bookTarget = bookTarget;
        }

        public Object getLibraryOrganization() {
            return libraryOrganization;
        }

        public void setLibraryOrganization(Object libraryOrganization) {
            this.libraryOrganization = libraryOrganization;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getBookAuthor() {
            return bookAuthor;
        }

        public void setBookAuthor(String bookAuthor) {
            this.bookAuthor = bookAuthor;
        }

        public String getPress() {
            return press;
        }

        public void setPress(String press) {
            this.press = press;
        }

        public long getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(long publishDate) {
            this.publishDate = publishDate;
        }

        public Object getPublishDatestr() {
            return publishDatestr;
        }

        public void setPublishDatestr(Object publishDatestr) {
            this.publishDatestr = publishDatestr;
        }

        public double getBookPrice() {
            return bookPrice;
        }

        public void setBookPrice(double bookPrice) {
            this.bookPrice = bookPrice;
        }

        public Object getAboutAuthor() {
            return aboutAuthor;
        }

        public void setAboutAuthor(Object aboutAuthor) {
            this.aboutAuthor = aboutAuthor;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getClassificationNumber() {
            return classificationNumber;
        }

        public void setClassificationNumber(String classificationNumber) {
            this.classificationNumber = classificationNumber;
        }

        public Object getSubjectTerm() {
            return subjectTerm;
        }

        public void setSubjectTerm(Object subjectTerm) {
            this.subjectTerm = subjectTerm;
        }

        public Object getBookLanguage() {
            return bookLanguage;
        }

        public void setBookLanguage(Object bookLanguage) {
            this.bookLanguage = bookLanguage;
        }

        public Object getBookEdition() {
            return bookEdition;
        }

        public void setBookEdition(Object bookEdition) {
            this.bookEdition = bookEdition;
        }

        public Object getTranslationAnnotation() {
            return translationAnnotation;
        }

        public void setTranslationAnnotation(Object translationAnnotation) {
            this.translationAnnotation = translationAnnotation;
        }

        public Object getBookSubtitle() {
            return bookSubtitle;
        }

        public void setBookSubtitle(Object bookSubtitle) {
            this.bookSubtitle = bookSubtitle;
        }

        public Object getSubjectClassificationNumbers() {
            return subjectClassificationNumbers;
        }

        public void setSubjectClassificationNumbers(Object subjectClassificationNumbers) {
            this.subjectClassificationNumbers = subjectClassificationNumbers;
        }

        public Object getWinningNumberClassification() {
            return winningNumberClassification;
        }

        public void setWinningNumberClassification(Object winningNumberClassification) {
            this.winningNumberClassification = winningNumberClassification;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getBindingLayout() {
            return bindingLayout;
        }

        public void setBindingLayout(Object bindingLayout) {
            this.bindingLayout = bindingLayout;
        }

        public Object getUploadDate() {
            return uploadDate;
        }

        public void setUploadDate(Object uploadDate) {
            this.uploadDate = uploadDate;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getBookType() {
            return bookType;
        }

        public void setBookType(Object bookType) {
            this.bookType = bookType;
        }

        public Object getOrganId() {
            return organId;
        }

        public void setOrganId(Object organId) {
            this.organId = organId;
        }

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
            this.country = country;
        }

        public Object getArea() {
            return area;
        }

        public void setArea(Object area) {
            this.area = area;
        }

        public Object getPhysicalAttr() {
            return physicalAttr;
        }

        public void setPhysicalAttr(Object physicalAttr) {
            this.physicalAttr = physicalAttr;
        }

        public Object getBookNamePY() {
            return bookNamePY;
        }

        public void setBookNamePY(Object bookNamePY) {
            this.bookNamePY = bookNamePY;
        }

        public Object getGeneralDataId() {
            return generalDataId;
        }

        public void setGeneralDataId(Object generalDataId) {
            this.generalDataId = generalDataId;
        }

        public Object getAnotherAuthor() {
            return anotherAuthor;
        }

        public void setAnotherAuthor(Object anotherAuthor) {
            this.anotherAuthor = anotherAuthor;
        }

        public Object getParallelTitle() {
            return parallelTitle;
        }

        public void setParallelTitle(Object parallelTitle) {
            this.parallelTitle = parallelTitle;
        }

        public Object getTranslator() {
            return translator;
        }

        public void setTranslator(Object translator) {
            this.translator = translator;
        }

        public Object getVolumesName() {
            return volumesName;
        }

        public void setVolumesName(Object volumesName) {
            this.volumesName = volumesName;
        }

        public Object getVolumesNo() {
            return volumesNo;
        }

        public void setVolumesNo(Object volumesNo) {
            this.volumesNo = volumesNo;
        }

        public Object getEditionState() {
            return editionState;
        }

        public void setEditionState(Object editionState) {
            this.editionState = editionState;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getPages() {
            return pages;
        }

        public void setPages(Object pages) {
            this.pages = pages;
        }

        public Object getChart() {
            return chart;
        }

        public void setChart(Object chart) {
            this.chart = chart;
        }

        public Object getSize() {
            return size;
        }

        public void setSize(Object size) {
            this.size = size;
        }

        public Object getAttachment() {
            return attachment;
        }

        public void setAttachment(Object attachment) {
            this.attachment = attachment;
        }

        public Object getSeriesName() {
            return seriesName;
        }

        public void setSeriesName(Object seriesName) {
            this.seriesName = seriesName;
        }

        public Object getSeriesNamePy() {
            return seriesNamePy;
        }

        public void setSeriesNamePy(Object seriesNamePy) {
            this.seriesNamePy = seriesNamePy;
        }

        public Object getSeriesAuthor() {
            return seriesAuthor;
        }

        public void setSeriesAuthor(Object seriesAuthor) {
            this.seriesAuthor = seriesAuthor;
        }

        public Object getGeneralNotes() {
            return generalNotes;
        }

        public void setGeneralNotes(Object generalNotes) {
            this.generalNotes = generalNotes;
        }

        public Object getPublicationNotes() {
            return publicationNotes;
        }

        public void setPublicationNotes(Object publicationNotes) {
            this.publicationNotes = publicationNotes;
        }

        public Object getResponsibilityNotes() {
            return responsibilityNotes;
        }

        public void setResponsibilityNotes(Object responsibilityNotes) {
            this.responsibilityNotes = responsibilityNotes;
        }

        public Object getUserNotes() {
            return userNotes;
        }

        public void setUserNotes(Object userNotes) {
            this.userNotes = userNotes;
        }

        public Object getParallelTitleProper() {
            return parallelTitleProper;
        }

        public void setParallelTitleProper(Object parallelTitleProper) {
            this.parallelTitleProper = parallelTitleProper;
        }

        public Object getPTPLanguage() {
            return pTPLanguage;
        }

        public void setPTPLanguage(Object pTPLanguage) {
            this.pTPLanguage = pTPLanguage;
        }

        public Object getPersonalSubject() {
            return personalSubject;
        }

        public void setPersonalSubject(Object personalSubject) {
            this.personalSubject = personalSubject;
        }

        public Object getCorporateSubject() {
            return corporateSubject;
        }

        public void setCorporateSubject(Object corporateSubject) {
            this.corporateSubject = corporateSubject;
        }

        public Object getTitleSubject() {
            return titleSubject;
        }

        public void setTitleSubject(Object titleSubject) {
            this.titleSubject = titleSubject;
        }

        public Object getTopicalSubject() {
            return topicalSubject;
        }

        public void setTopicalSubject(Object topicalSubject) {
            this.topicalSubject = topicalSubject;
        }

        public Object getGeographicalSubject() {
            return geographicalSubject;
        }

        public void setGeographicalSubject(Object geographicalSubject) {
            this.geographicalSubject = geographicalSubject;
        }

        public Object getUncontrolledSubject() {
            return uncontrolledSubject;
        }

        public void setUncontrolledSubject(Object uncontrolledSubject) {
            this.uncontrolledSubject = uncontrolledSubject;
        }

        public Object getLccas() {
            return lccas;
        }

        public void setLccas(Object lccas) {
            this.lccas = lccas;
        }

        public Object getAir() {
            return air;
        }

        public void setAir(Object air) {
            this.air = air;
        }

        public Object getAirPy() {
            return airPy;
        }

        public void setAirPy(Object airPy) {
            this.airPy = airPy;
        }

        public Object getSir() {
            return sir;
        }

        public void setSir(Object sir) {
            this.sir = sir;
        }

        public Object getSirPy() {
            return sirPy;
        }

        public void setSirPy(Object sirPy) {
            this.sirPy = sirPy;
        }

        public Object getPir() {
            return pir;
        }

        public void setPir(Object pir) {
            this.pir = pir;
        }

        public Object getOriginatingSource() {
            return originatingSource;
        }

        public void setOriginatingSource(Object originatingSource) {
            this.originatingSource = originatingSource;
        }

        public Object getDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(Object deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public Object getShelveDate() {
            return shelveDate;
        }

        public void setShelveDate(Object shelveDate) {
            this.shelveDate = shelveDate;
        }

        public String getBookStarLevel() {
            return bookStarLevel;
        }

        public void setBookStarLevel(String bookStarLevel) {
            this.bookStarLevel = bookStarLevel;
        }

        public Object getSpecialColumnId() {
            return specialColumnId;
        }

        public void setSpecialColumnId(Object specialColumnId) {
            this.specialColumnId = specialColumnId;
        }

        public List<BookFilesBean> getBookFiles() {
            return bookFiles;
        }

        public void setBookFiles(List<BookFilesBean> bookFiles) {
            this.bookFiles = bookFiles;
        }

        public List<BookPicturesBean> getBookPictures() {
            return bookPictures;
        }

        public void setBookPictures(List<BookPicturesBean> bookPictures) {
            this.bookPictures = bookPictures;
        }

        public static class BookTargetBean {
            /**
             * id : null
             * bookId : de5102c61e7911e7bd1f00163e160aa8
             * electronic : null
             * rightStartDate : null
             * rightEndDate : null
             * rightFromId : null
             * rightFromName : null
             * count : null
             * reponsibilityEdition : null
             * charNumber : null
             * cano : null
             * ano : null
             * other1 : null
             * other2 : null
             * other3 : null
             * other4 : null
             * other5 : null
             * buyerId : null
             * buyerName : null
             * buyDate : null
             * createUserId : null
             * createUserName : null
             * createDate : null
             * checkerId : null
             * checkerName : null
             * checkFlag : null
             * checkNotes : null
             * flagEnd : null
             * fileSize : null
             * modifyUserId : null
             * modifyUserName : null
             * modifyDate : null
             */

            private Object id;
            private String bookId;
            private Object electronic;
            private Object rightStartDate;
            private Object rightEndDate;
            private Object rightFromId;
            private Object rightFromName;
            private Object count;
            private Object reponsibilityEdition;
            private Object charNumber;
            private Object cano;
            private Object ano;
            private Object other1;
            private Object other2;
            private Object other3;
            private Object other4;
            private Object other5;
            private Object buyerId;
            private Object buyerName;
            private Object buyDate;
            private Object createUserId;
            private Object createUserName;
            private Object createDate;
            private Object checkerId;
            private Object checkerName;
            private Object checkFlag;
            private Object checkNotes;
            private Object flagEnd;
            private Object fileSize;
            private Object modifyUserId;
            private Object modifyUserName;
            private Object modifyDate;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public String getBookId() {
                return bookId;
            }

            public void setBookId(String bookId) {
                this.bookId = bookId;
            }

            public Object getElectronic() {
                return electronic;
            }

            public void setElectronic(Object electronic) {
                this.electronic = electronic;
            }

            public Object getRightStartDate() {
                return rightStartDate;
            }

            public void setRightStartDate(Object rightStartDate) {
                this.rightStartDate = rightStartDate;
            }

            public Object getRightEndDate() {
                return rightEndDate;
            }

            public void setRightEndDate(Object rightEndDate) {
                this.rightEndDate = rightEndDate;
            }

            public Object getRightFromId() {
                return rightFromId;
            }

            public void setRightFromId(Object rightFromId) {
                this.rightFromId = rightFromId;
            }

            public Object getRightFromName() {
                return rightFromName;
            }

            public void setRightFromName(Object rightFromName) {
                this.rightFromName = rightFromName;
            }

            public Object getCount() {
                return count;
            }

            public void setCount(Object count) {
                this.count = count;
            }

            public Object getReponsibilityEdition() {
                return reponsibilityEdition;
            }

            public void setReponsibilityEdition(Object reponsibilityEdition) {
                this.reponsibilityEdition = reponsibilityEdition;
            }

            public Object getCharNumber() {
                return charNumber;
            }

            public void setCharNumber(Object charNumber) {
                this.charNumber = charNumber;
            }

            public Object getCano() {
                return cano;
            }

            public void setCano(Object cano) {
                this.cano = cano;
            }

            public Object getAno() {
                return ano;
            }

            public void setAno(Object ano) {
                this.ano = ano;
            }

            public Object getOther1() {
                return other1;
            }

            public void setOther1(Object other1) {
                this.other1 = other1;
            }

            public Object getOther2() {
                return other2;
            }

            public void setOther2(Object other2) {
                this.other2 = other2;
            }

            public Object getOther3() {
                return other3;
            }

            public void setOther3(Object other3) {
                this.other3 = other3;
            }

            public Object getOther4() {
                return other4;
            }

            public void setOther4(Object other4) {
                this.other4 = other4;
            }

            public Object getOther5() {
                return other5;
            }

            public void setOther5(Object other5) {
                this.other5 = other5;
            }

            public Object getBuyerId() {
                return buyerId;
            }

            public void setBuyerId(Object buyerId) {
                this.buyerId = buyerId;
            }

            public Object getBuyerName() {
                return buyerName;
            }

            public void setBuyerName(Object buyerName) {
                this.buyerName = buyerName;
            }

            public Object getBuyDate() {
                return buyDate;
            }

            public void setBuyDate(Object buyDate) {
                this.buyDate = buyDate;
            }

            public Object getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(Object createUserId) {
                this.createUserId = createUserId;
            }

            public Object getCreateUserName() {
                return createUserName;
            }

            public void setCreateUserName(Object createUserName) {
                this.createUserName = createUserName;
            }

            public Object getCreateDate() {
                return createDate;
            }

            public void setCreateDate(Object createDate) {
                this.createDate = createDate;
            }

            public Object getCheckerId() {
                return checkerId;
            }

            public void setCheckerId(Object checkerId) {
                this.checkerId = checkerId;
            }

            public Object getCheckerName() {
                return checkerName;
            }

            public void setCheckerName(Object checkerName) {
                this.checkerName = checkerName;
            }

            public Object getCheckFlag() {
                return checkFlag;
            }

            public void setCheckFlag(Object checkFlag) {
                this.checkFlag = checkFlag;
            }

            public Object getCheckNotes() {
                return checkNotes;
            }

            public void setCheckNotes(Object checkNotes) {
                this.checkNotes = checkNotes;
            }

            public Object getFlagEnd() {
                return flagEnd;
            }

            public void setFlagEnd(Object flagEnd) {
                this.flagEnd = flagEnd;
            }

            public Object getFileSize() {
                return fileSize;
            }

            public void setFileSize(Object fileSize) {
                this.fileSize = fileSize;
            }

            public Object getModifyUserId() {
                return modifyUserId;
            }

            public void setModifyUserId(Object modifyUserId) {
                this.modifyUserId = modifyUserId;
            }

            public Object getModifyUserName() {
                return modifyUserName;
            }

            public void setModifyUserName(Object modifyUserName) {
                this.modifyUserName = modifyUserName;
            }

            public Object getModifyDate() {
                return modifyDate;
            }

            public void setModifyDate(Object modifyDate) {
                this.modifyDate = modifyDate;
            }
        }

        public static class BookFilesBean {
            /**
             * id : null
             * bookId : null
             * origName : 978-7-5470-2368-6_de5102c61e7911e7bd1f00163e160aa8.epub
             * fileSize : 206947
             * filePath : group1/M00/03/4F/Zcl0lljsinaAKUE1AAMoY1ys97Q53.epub
             * fileExt : epub
             * tableContent : 封面
             版权信息
             序言
             感悟
             《忆》跋
             荷塘月色
             春
             买书
             故人
             我是扬州人
             教育家的夏丏尊先生
             阿河
             给亡妇
             我所见的叶圣陶
             踪迹
             温州的踪迹
             旅行杂记
             重庆行记
             蒙自杂记
             思索
             航船中的文明
             白种人——上帝的骄子
             沉默
             论诚意
             论废话
             论气节
             伦敦杂记
             三家书店
             文人宅
             博物院
             公园
             加尔东尼市场
             吃的
             乞丐
             圣诞节
             房东太太
             * attachType : 1
             * isMark : null
             * isUsing : null
             */

            private Object id;
            private Object bookId;
            private String origName;
            private int fileSize;
            private String filePath;
            private String fileExt;
            private String tableContent;
            private int attachType;
            private Object isMark;
            private Object isUsing;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getBookId() {
                return bookId;
            }

            public void setBookId(Object bookId) {
                this.bookId = bookId;
            }

            public String getOrigName() {
                return origName;
            }

            public void setOrigName(String origName) {
                this.origName = origName;
            }

            public int getFileSize() {
                return fileSize;
            }

            public void setFileSize(int fileSize) {
                this.fileSize = fileSize;
            }

            public String getFilePath() {
                return filePath;
            }

            public void setFilePath(String filePath) {
                this.filePath = filePath;
            }

            public String getFileExt() {
                return fileExt;
            }

            public void setFileExt(String fileExt) {
                this.fileExt = fileExt;
            }

            public String getTableContent() {
                return tableContent;
            }

            public void setTableContent(String tableContent) {
                this.tableContent = tableContent;
            }

            public int getAttachType() {
                return attachType;
            }

            public void setAttachType(int attachType) {
                this.attachType = attachType;
            }

            public Object getIsMark() {
                return isMark;
            }

            public void setIsMark(Object isMark) {
                this.isMark = isMark;
            }

            public Object getIsUsing() {
                return isUsing;
            }

            public void setIsUsing(Object isUsing) {
                this.isUsing = isUsing;
            }
        }

        public static class BookPicturesBean {
            /**
             * id : null
             * bookId : null
             * origName : 978-7-5470-2368-6_de5102c61e7911e7bd1f00163e160aa8.jpg
             * fileSize : 53182
             * filePath : group1/M00/03/4F/Zcl0d1jsinuAdeoHAAAqjrPNNrI876.jpg
             * fileExt : jpg
             * tableContent : null
             * attachType : 2
             * isMark : null
             * isUsing : null
             */

            private Object id;
            private Object bookId;
            private String origName;
            private int fileSize;
            private String filePath;
            private String fileExt;
            private Object tableContent;
            private int attachType;
            private Object isMark;
            private Object isUsing;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getBookId() {
                return bookId;
            }

            public void setBookId(Object bookId) {
                this.bookId = bookId;
            }

            public String getOrigName() {
                return origName;
            }

            public void setOrigName(String origName) {
                this.origName = origName;
            }

            public int getFileSize() {
                return fileSize;
            }

            public void setFileSize(int fileSize) {
                this.fileSize = fileSize;
            }

            public String getFilePath() {
                return filePath;
            }

            public void setFilePath(String filePath) {
                this.filePath = filePath;
            }

            public String getFileExt() {
                return fileExt;
            }

            public void setFileExt(String fileExt) {
                this.fileExt = fileExt;
            }

            public Object getTableContent() {
                return tableContent;
            }

            public void setTableContent(Object tableContent) {
                this.tableContent = tableContent;
            }

            public int getAttachType() {
                return attachType;
            }

            public void setAttachType(int attachType) {
                this.attachType = attachType;
            }

            public Object getIsMark() {
                return isMark;
            }

            public void setIsMark(Object isMark) {
                this.isMark = isMark;
            }

            public Object getIsUsing() {
                return isUsing;
            }

            public void setIsUsing(Object isUsing) {
                this.isUsing = isUsing;
            }
        }
    }
}
