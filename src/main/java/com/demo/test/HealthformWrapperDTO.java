package com.demo.test;

public class HealthformWrapperDTO {

    private final static String NONE = "无";
    /** true高血压 false不是高血压 */
    private boolean hyper;
    /** true糖尿病 false不是糖尿病 */
    private boolean diab;
    /** true精神病 false不是精神病 */
    private boolean mental;
    /** true老年人 false不是老年人 */
    private boolean old;
    /** true结核病 false不是结核病 */
    private boolean tuber;
    /** true孕产妇 false不是孕产妇 */
    private boolean maternal;
    /** true儿童 false不是儿童 */
    private boolean child;
    /** 体检表数据 */
    private Healthform data;
    /** 非免疫规划接种史 */


    private boolean needDefault;

    public boolean isHyper() {
        return hyper;
    }

    public void setHyper(boolean hyper) {
        this.hyper = hyper;
    }

    public boolean isDiab() {
        return diab;
    }

    public void setDiab(boolean diab) {
        this.diab = diab;
    }

    public boolean isMental() {
        return mental;
    }

    public void setMental(boolean mental) {
        this.mental = mental;
    }

    public boolean isOld() {
        return old;
    }

    public void setOld(boolean old) {
        this.old = old;
    }

    public boolean isTuber() {
        return tuber;
    }

    public void setTuber(boolean tuber) {
        this.tuber = tuber;
    }

    public boolean isMaternal() {
        return maternal;
    }

    public void setMaternal(boolean maternal) {
        this.maternal = maternal;
    }

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }






    public boolean isNeedDefault() {
        return needDefault;
    }

    public void setNeedDefault(boolean needDefault) {
        this.needDefault = needDefault;
    }







}
