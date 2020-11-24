package test_pageObj_wx_web;

/**
 * @param
 * @Auther: zhangcheng
 * @Date: 2020/11/15 23:37
 * @Description:添加成员方法
 */
public class ContactPageView {


    /**
     *  @param name 企业微信名称
     * @param acctid
     * @param mobile shoujihao
     * @return
     */
    public ContactPageView addMember( String name, String acctid, String mobile){
        return this;
    }

    /**
     *
     * @param departName 部门名称
     * @return
     */
    public ContactPageView addDepart( String departName){
        return this;
    }

}
