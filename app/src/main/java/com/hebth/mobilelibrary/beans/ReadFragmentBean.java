package com.hebth.mobilelibrary.beans;

import com.hebth.mobilelibrary.ui.main.fragments.ebook.net.ReadParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * Created by hebth on 2017-06-09.
 * readfragment的实体类
 */
@HttpResponse(parser = ReadParser.class)
public class ReadFragmentBean {

    /**
     * msg : 获取成功
     * code : 200
     * data : {"lastPage":8,"navigatepageNums":[1,2,3,4,5,6,7,8],"startRow":1,"hasNextPage":true,"prePage":0,"nextPage":2,"endRow":12,"pageSize":12,"list":[{"isbn":"978-7-5470-2314-3","publishDate":1396281600000,"description":"本书共十二章，内容包括：超越自我，追逐成功；理想是船，信念是帆；精神凝聚力量；魅力即是引力；形象营造气场；做最好的自己；胆子再大点儿；思考是智者的特权；用淡定面对一切等。","publishDatestr":"2014-04-01","bookAuthor":"蒋光宇","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsinuAKtcJAAAyS6vFjww339.jpg"}],"bookName":"钢琴上的黑白左右手","bookStarLevel":"1","airPy":"1","bookPrice":19.8,"id":"de50d36c1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2368-6","publishDate":1343750400000,"description":"本书是一本电话销售方法的原创读本。《电话销售28堂实战训练课》凝聚着一位成功销售人士的推销心经。《电话销售28堂实战训练课》通过原因分析、解决方法、故事导入的三种形式把电话推销方法融入其中，内容简洁、通俗、易懂。","publishDatestr":"2012-08-01","bookAuthor":"朱自清","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsinuAdeoHAAAqjrPNNrI876.jpg"}],"bookName":"荷塘月色","bookStarLevel":"1","airPy":"1","bookPrice":19.8,"id":"de5102c61e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2369-3","publishDate":1446307200000,"description":"社会主义核心价值体系，是中国精神的旗帜，是中华民族传统美德和时代精神的完美结合。广大青少年如何努力塑造自己，成为有理想、有道德、有文化、有纪律的德智体美全面发展的社会主义合格建设者和接班人，需要自觉地学习体会践行社会主义核心价值体系的要求，夯实思想基础，坚定走中国特色社会主义的信念，为实现中华民族伟大复兴贡献力量。","publishDatestr":"2015-11-01","bookAuthor":"鲁迅","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsinyAfX0EAAAsOo8QqRg636.jpg"}],"bookName":"朝花夕拾","bookStarLevel":"1","airPy":"1","bookPrice":19.8,"id":"de5135cc1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2510-9","publishDate":1446307200000,"description":"社会主义核心价值体系，是中国精神的旗帜，是中华民族传统美德和时代精神的完美结合。广大青少年如何努力塑造自己，成为有理想、有道德、有文化、有纪律的德智体美全面发展的社会主义合格建设者和接班人，需要自觉地学习体会践行社会主义核心价值体系的要求，夯实思想基础，坚定走中国特色社会主义的信念，为实现中华民族伟大复兴贡献力量。","publishDatestr":"2015-11-01","bookAuthor":"鲁迅","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsinyAezNDAAA6tiDweYA769.jpg"}],"bookName":"鲁迅散文集","bookStarLevel":"0","airPy":"1","bookPrice":20,"id":"de5199aa1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2511-6","publishDate":1343750400000,"description":"本书是一本电话销售方法的原创读本。《电话销售28堂实战训练课》凝聚着一位成功销售人士的推销心经。《电话销售28堂实战训练课》通过原因分析、解决方法、故事导入的三种形式把电话推销方法融入其中，内容简洁、通俗、易懂。","publishDatestr":"2012-08-01","bookAuthor":"朱自清","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin2ASvteAAA8c7wFskE858.jpg"}],"bookName":"朱自清散文集","bookStarLevel":"1","airPy":"1","bookPrice":20,"id":"de51c88a1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2523-9","publishDate":1446307200000,"description":"社会主义核心价值体系，是中国精神的旗帜，是中华民族传统美德和时代精神的完美结合。广大青少年如何努力塑造自己，成为有理想、有道德、有文化、有纪律的德智体美全面发展的社会主义合格建设者和接班人，需要自觉地学习体会践行社会主义核心价值体系的要求，夯实思想基础，坚定走中国特色社会主义的信念，为实现中华民族伟大复兴贡献力量。","publishDatestr":"2015-11-01","bookAuthor":"鲁迅","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin2ASQa6AABCQkJHU_k078.jpg"}],"bookName":"鲁迅小说集（万卷）","bookStarLevel":"0","airPy":"1","bookPrice":20,"id":"de520d181e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2524-6","publishDate":1446307200000,"description":"社会主义核心价值体系，是中国精神的旗帜，是中华民族传统美德和时代精神的完美结合。广大青少年如何努力塑造自己，成为有理想、有道德、有文化、有纪律的德智体美全面发展的社会主义合格建设者和接班人，需要自觉地学习体会践行社会主义核心价值体系的要求，夯实思想基础，坚定走中国特色社会主义的信念，为实现中华民族伟大复兴贡献力量。","publishDatestr":"2015-11-01","bookAuthor":"鲁迅","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin2ARgaTAABI7NBiI1s274.jpg"}],"bookName":"鲁迅杂文集","bookStarLevel":"0","airPy":"1","bookPrice":20,"id":"de5247db1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2607-6","publishDate":1446307200000,"description":"社会主义核心价值体系，是中国精神的旗帜，是中华民族传统美德和时代精神的完美结合。广大青少年如何努力塑造自己，成为有理想、有道德、有文化、有纪律的德智体美全面发展的社会主义合格建设者和接班人，需要自觉地学习体会践行社会主义核心价值体系的要求，夯实思想基础，坚定走中国特色社会主义的信念，为实现中华民族伟大复兴贡献力量。","publishDatestr":"2015-11-01","bookAuthor":"鲁迅","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin6AHbdiAAAoGzeJic4551.jpg"}],"bookName":"呐喊","bookStarLevel":"0","airPy":"1","bookPrice":19.8,"id":"de527a3c1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2670-0","publishDate":1401552000000,"description":"本书主要内容为作者在小学教学中的成长之路、经验反思、精品课堂的文章。","publishDatestr":"2014-06-01","bookAuthor":"[英]莎士比亚","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin6AN-gwAAAvwq0aBgc080.jpg"}],"bookName":"威尼斯商人","bookStarLevel":"0","airPy":"1","bookPrice":19.8,"id":"de52aea61e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2922-0","publishDate":1393603200000,"description":"所有第一次见到武丹的人都会觉得这是个圆圆的不谙世事的小姑娘，从她的文字里我觉得她早就已经像她希望的那样成为了一个明媚而温暖的女子。在现在这样的时候，能像她这样保持写字的习惯是很难得的。我想每个人的一生大致都要经历这样一些情绪，无知、失望、渴盼、迷茫、振作，但我想每个人也都一定会度过这个阶段，总有一天，我们会到达这样一个年龄，你能够理解和宽恕所有已经历过的和正在经历的波折，走向成熟。这本书，出自一个刚刚大学毕业，刚刚踏入电视行业的年轻人，她让我看到一个已经能够宽恕和理解并且从未对生活丧失过感激和热爱的丰盛的青春。这些文字初看觉得絮叨或者散漫，慢慢地才能读出它暗香浮动的安宁与灵气。做电视需要有思想，做文字需要有涵养，而做年轻人，要像这本书一样，二者兼备。这些文字也许不能给你带来振奋与激情，但我想你一定能从中看到我们早已熟知的生活的另一面，并且找到安慰和感动。毕竟，发现他人同时也就发现了自己。","publishDatestr":"2014-03-01","bookAuthor":"徐志摩","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin-AW_i7AAAt2kNFvsM454.jpg"}],"bookName":"再别康桥","bookStarLevel":"0","airPy":"1","bookPrice":19.8,"id":"de5351861e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2919-0","publishDate":1372608000000,"description":"本书通过哲学家的眼光去审视幸福。通过哲学家深邃的目光把幸福看得更为透彻，并通过幸福来审视作为一个人的终极意义。","publishDatestr":"2013-07-01","bookAuthor":"洪汛涛","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin6ACL6lAAA1VfxKh_E468.jpg"}],"bookName":"神笔马良","bookStarLevel":"0","airPy":"1","bookPrice":19.8,"id":"de52efbd1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2920-6","publishDate":1367337600000,"description":"本书全面介绍红领巾助残活动的起源、发展、经验和操作模式，并有针对地系统介绍帮扶残疾人所需要掌握的各种常识、技巧和禁忌等。","publishDatestr":"2013-05-01","bookAuthor":"王充闾","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin-AK2E9AAA4_v_qmmM454.jpg"}],"bookName":"童年的风景","bookStarLevel":"0","airPy":"1","bookPrice":19.8,"id":"de5321551e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"}],"pageNum":1,"navigatePages":8,"total":8679,"pages":724,"firstPage":1,"size":12,"isLastPage":false,"hasPreviousPage":false,"isFirstPage":true}
     * responseCode : 200
     * status : 1
     */

    private String msg;
    private String code;
    private DataBean data;
    private String responseCode;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * lastPage : 8
         * navigatepageNums : [1,2,3,4,5,6,7,8]
         * startRow : 1
         * hasNextPage : true
         * prePage : 0
         * nextPage : 2
         * endRow : 12
         * pageSize : 12
         * list : [{"isbn":"978-7-5470-2314-3","publishDate":1396281600000,"description":"本书共十二章，内容包括：超越自我，追逐成功；理想是船，信念是帆；精神凝聚力量；魅力即是引力；形象营造气场；做最好的自己；胆子再大点儿；思考是智者的特权；用淡定面对一切等。","publishDatestr":"2014-04-01","bookAuthor":"蒋光宇","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsinuAKtcJAAAyS6vFjww339.jpg"}],"bookName":"钢琴上的黑白左右手","bookStarLevel":"1","airPy":"1","bookPrice":19.8,"id":"de50d36c1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2368-6","publishDate":1343750400000,"description":"本书是一本电话销售方法的原创读本。《电话销售28堂实战训练课》凝聚着一位成功销售人士的推销心经。《电话销售28堂实战训练课》通过原因分析、解决方法、故事导入的三种形式把电话推销方法融入其中，内容简洁、通俗、易懂。","publishDatestr":"2012-08-01","bookAuthor":"朱自清","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsinuAdeoHAAAqjrPNNrI876.jpg"}],"bookName":"荷塘月色","bookStarLevel":"1","airPy":"1","bookPrice":19.8,"id":"de5102c61e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2369-3","publishDate":1446307200000,"description":"社会主义核心价值体系，是中国精神的旗帜，是中华民族传统美德和时代精神的完美结合。广大青少年如何努力塑造自己，成为有理想、有道德、有文化、有纪律的德智体美全面发展的社会主义合格建设者和接班人，需要自觉地学习体会践行社会主义核心价值体系的要求，夯实思想基础，坚定走中国特色社会主义的信念，为实现中华民族伟大复兴贡献力量。","publishDatestr":"2015-11-01","bookAuthor":"鲁迅","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsinyAfX0EAAAsOo8QqRg636.jpg"}],"bookName":"朝花夕拾","bookStarLevel":"1","airPy":"1","bookPrice":19.8,"id":"de5135cc1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2510-9","publishDate":1446307200000,"description":"社会主义核心价值体系，是中国精神的旗帜，是中华民族传统美德和时代精神的完美结合。广大青少年如何努力塑造自己，成为有理想、有道德、有文化、有纪律的德智体美全面发展的社会主义合格建设者和接班人，需要自觉地学习体会践行社会主义核心价值体系的要求，夯实思想基础，坚定走中国特色社会主义的信念，为实现中华民族伟大复兴贡献力量。","publishDatestr":"2015-11-01","bookAuthor":"鲁迅","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsinyAezNDAAA6tiDweYA769.jpg"}],"bookName":"鲁迅散文集","bookStarLevel":"0","airPy":"1","bookPrice":20,"id":"de5199aa1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2511-6","publishDate":1343750400000,"description":"本书是一本电话销售方法的原创读本。《电话销售28堂实战训练课》凝聚着一位成功销售人士的推销心经。《电话销售28堂实战训练课》通过原因分析、解决方法、故事导入的三种形式把电话推销方法融入其中，内容简洁、通俗、易懂。","publishDatestr":"2012-08-01","bookAuthor":"朱自清","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin2ASvteAAA8c7wFskE858.jpg"}],"bookName":"朱自清散文集","bookStarLevel":"1","airPy":"1","bookPrice":20,"id":"de51c88a1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2523-9","publishDate":1446307200000,"description":"社会主义核心价值体系，是中国精神的旗帜，是中华民族传统美德和时代精神的完美结合。广大青少年如何努力塑造自己，成为有理想、有道德、有文化、有纪律的德智体美全面发展的社会主义合格建设者和接班人，需要自觉地学习体会践行社会主义核心价值体系的要求，夯实思想基础，坚定走中国特色社会主义的信念，为实现中华民族伟大复兴贡献力量。","publishDatestr":"2015-11-01","bookAuthor":"鲁迅","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin2ASQa6AABCQkJHU_k078.jpg"}],"bookName":"鲁迅小说集（万卷）","bookStarLevel":"0","airPy":"1","bookPrice":20,"id":"de520d181e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2524-6","publishDate":1446307200000,"description":"社会主义核心价值体系，是中国精神的旗帜，是中华民族传统美德和时代精神的完美结合。广大青少年如何努力塑造自己，成为有理想、有道德、有文化、有纪律的德智体美全面发展的社会主义合格建设者和接班人，需要自觉地学习体会践行社会主义核心价值体系的要求，夯实思想基础，坚定走中国特色社会主义的信念，为实现中华民族伟大复兴贡献力量。","publishDatestr":"2015-11-01","bookAuthor":"鲁迅","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin2ARgaTAABI7NBiI1s274.jpg"}],"bookName":"鲁迅杂文集","bookStarLevel":"0","airPy":"1","bookPrice":20,"id":"de5247db1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2607-6","publishDate":1446307200000,"description":"社会主义核心价值体系，是中国精神的旗帜，是中华民族传统美德和时代精神的完美结合。广大青少年如何努力塑造自己，成为有理想、有道德、有文化、有纪律的德智体美全面发展的社会主义合格建设者和接班人，需要自觉地学习体会践行社会主义核心价值体系的要求，夯实思想基础，坚定走中国特色社会主义的信念，为实现中华民族伟大复兴贡献力量。","publishDatestr":"2015-11-01","bookAuthor":"鲁迅","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin6AHbdiAAAoGzeJic4551.jpg"}],"bookName":"呐喊","bookStarLevel":"0","airPy":"1","bookPrice":19.8,"id":"de527a3c1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2670-0","publishDate":1401552000000,"description":"本书主要内容为作者在小学教学中的成长之路、经验反思、精品课堂的文章。","publishDatestr":"2014-06-01","bookAuthor":"[英]莎士比亚","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin6AN-gwAAAvwq0aBgc080.jpg"}],"bookName":"威尼斯商人","bookStarLevel":"0","airPy":"1","bookPrice":19.8,"id":"de52aea61e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2922-0","publishDate":1393603200000,"description":"所有第一次见到武丹的人都会觉得这是个圆圆的不谙世事的小姑娘，从她的文字里我觉得她早就已经像她希望的那样成为了一个明媚而温暖的女子。在现在这样的时候，能像她这样保持写字的习惯是很难得的。我想每个人的一生大致都要经历这样一些情绪，无知、失望、渴盼、迷茫、振作，但我想每个人也都一定会度过这个阶段，总有一天，我们会到达这样一个年龄，你能够理解和宽恕所有已经历过的和正在经历的波折，走向成熟。这本书，出自一个刚刚大学毕业，刚刚踏入电视行业的年轻人，她让我看到一个已经能够宽恕和理解并且从未对生活丧失过感激和热爱的丰盛的青春。这些文字初看觉得絮叨或者散漫，慢慢地才能读出它暗香浮动的安宁与灵气。做电视需要有思想，做文字需要有涵养，而做年轻人，要像这本书一样，二者兼备。这些文字也许不能给你带来振奋与激情，但我想你一定能从中看到我们早已熟知的生活的另一面，并且找到安慰和感动。毕竟，发现他人同时也就发现了自己。","publishDatestr":"2014-03-01","bookAuthor":"徐志摩","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin-AW_i7AAAt2kNFvsM454.jpg"}],"bookName":"再别康桥","bookStarLevel":"0","airPy":"1","bookPrice":19.8,"id":"de5351861e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2919-0","publishDate":1372608000000,"description":"本书通过哲学家的眼光去审视幸福。通过哲学家深邃的目光把幸福看得更为透彻，并通过幸福来审视作为一个人的终极意义。","publishDatestr":"2013-07-01","bookAuthor":"洪汛涛","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin6ACL6lAAA1VfxKh_E468.jpg"}],"bookName":"神笔马良","bookStarLevel":"0","airPy":"1","bookPrice":19.8,"id":"de52efbd1e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"},{"isbn":"978-7-5470-2920-6","publishDate":1367337600000,"description":"本书全面介绍红领巾助残活动的起源、发展、经验和操作模式，并有针对地系统介绍帮扶残疾人所需要掌握的各种常识、技巧和禁忌等。","publishDatestr":"2013-05-01","bookAuthor":"王充闾","bookPictures":[{"filePath":"group1/M00/03/4F/Zcl0d1jsin-AK2E9AAA4_v_qmmM454.jpg"}],"bookName":"童年的风景","bookStarLevel":"0","airPy":"1","bookPrice":19.8,"id":"de5321551e7911e7bd1f00163e160aa8","press":"万卷出版公司","bookType":"L15_1"}]
         * pageNum : 1
         * navigatePages : 8
         * total : 8679
         * pages : 724
         * firstPage : 1
         * size : 12
         * isLastPage : false
         * hasPreviousPage : false
         * isFirstPage : true
         */

        private int lastPage;
        private int startRow;
        private boolean hasNextPage;
        private int prePage;
        private int nextPage;
        private int endRow;
        private int pageSize;
        private int pageNum;
        private int navigatePages;
        private int total;
        private int pages;
        private int firstPage;
        private int size;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean isFirstPage;
        private List<Integer> navigatepageNums;
        private List<ListBean> list;

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * isbn : 978-7-5470-2314-3
             * publishDate : 1396281600000
             * description : 本书共十二章，内容包括：超越自我，追逐成功；理想是船，信念是帆；精神凝聚力量；魅力即是引力；形象营造气场；做最好的自己；胆子再大点儿；思考是智者的特权；用淡定面对一切等。
             * publishDatestr : 2014-04-01
             * bookAuthor : 蒋光宇
             * bookPictures : [{"filePath":"group1/M00/03/4F/Zcl0d1jsinuAKtcJAAAyS6vFjww339.jpg"}]
             * bookName : 钢琴上的黑白左右手
             * bookStarLevel : 1
             * airPy : 1
             * bookPrice : 19.8
             * id : de50d36c1e7911e7bd1f00163e160aa8
             * press : 万卷出版公司
             * bookType : L15_1
             */

            private String isbn;
            private long publishDate;
            private String description;
            private String publishDatestr;
            private String bookAuthor;
            private String bookName;
            private String bookStarLevel;
            private String airPy;
            private double bookPrice;
            private String id;
            private String press;
            private String bookType;
            private List<BookPicturesBean> bookPictures;

            public String getIsbn() {
                return isbn;
            }

            public void setIsbn(String isbn) {
                this.isbn = isbn;
            }

            public long getPublishDate() {
                return publishDate;
            }

            public void setPublishDate(long publishDate) {
                this.publishDate = publishDate;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPublishDatestr() {
                return publishDatestr;
            }

            public void setPublishDatestr(String publishDatestr) {
                this.publishDatestr = publishDatestr;
            }

            public String getBookAuthor() {
                return bookAuthor;
            }

            public void setBookAuthor(String bookAuthor) {
                this.bookAuthor = bookAuthor;
            }

            public String getBookName() {
                return bookName;
            }

            public void setBookName(String bookName) {
                this.bookName = bookName;
            }

            public String getBookStarLevel() {
                return bookStarLevel;
            }

            public void setBookStarLevel(String bookStarLevel) {
                this.bookStarLevel = bookStarLevel;
            }

            public String getAirPy() {
                return airPy;
            }

            public void setAirPy(String airPy) {
                this.airPy = airPy;
            }

            public double getBookPrice() {
                return bookPrice;
            }

            public void setBookPrice(double bookPrice) {
                this.bookPrice = bookPrice;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPress() {
                return press;
            }

            public void setPress(String press) {
                this.press = press;
            }

            public String getBookType() {
                return bookType;
            }

            public void setBookType(String bookType) {
                this.bookType = bookType;
            }

            public List<BookPicturesBean> getBookPictures() {
                return bookPictures;
            }

            public void setBookPictures(List<BookPicturesBean> bookPictures) {
                this.bookPictures = bookPictures;
            }

            public static class BookPicturesBean {
                /**
                 * filePath : group1/M00/03/4F/Zcl0d1jsinuAKtcJAAAyS6vFjww339.jpg
                 */

                private String filePath;

                public String getFilePath() {
                    return filePath;
                }

                public void setFilePath(String filePath) {
                    this.filePath = filePath;
                }

                @Override
                public String toString() {
                    return "BookPicturesBean{" +
                            "filePath='" + filePath + '\'' +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "isbn='" + isbn + '\'' +
                        ", publishDate=" + publishDate +
                        ", description='" + description + '\'' +
                        ", publishDatestr='" + publishDatestr + '\'' +
                        ", bookAuthor='" + bookAuthor + '\'' +
                        ", bookName='" + bookName + '\'' +
                        ", bookStarLevel='" + bookStarLevel + '\'' +
                        ", airPy='" + airPy + '\'' +
                        ", bookPrice=" + bookPrice +
                        ", id='" + id + '\'' +
                        ", press='" + press + '\'' +
                        ", bookType='" + bookType + '\'' +
                        ", bookPictures=" + bookPictures +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "lastPage=" + lastPage +
                    ", startRow=" + startRow +
                    ", hasNextPage=" + hasNextPage +
                    ", prePage=" + prePage +
                    ", nextPage=" + nextPage +
                    ", endRow=" + endRow +
                    ", pageSize=" + pageSize +
                    ", pageNum=" + pageNum +
                    ", navigatePages=" + navigatePages +
                    ", total=" + total +
                    ", pages=" + pages +
                    ", firstPage=" + firstPage +
                    ", size=" + size +
                    ", isLastPage=" + isLastPage +
                    ", hasPreviousPage=" + hasPreviousPage +
                    ", isFirstPage=" + isFirstPage +
                    ", navigatepageNums=" + navigatepageNums +
                    ", list=" + list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ReadFragmentBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                ", responseCode='" + responseCode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
