package com.demo.dto;

public class HealthDTO {
    private User user;
    private String orgName;
    private String examY;
    private String examM;
    private String examD;
    private String bmi;
    private String height;
    private String weight;
    private Body body;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getExamY() {
        return examY;
    }

    public void setExamY(String examY) {
        this.examY = examY;
    }

    public String getExamM() {
        return examM;
    }

    public void setExamM(String examM) {
        this.examM = examM;
    }

    public String getExamD() {
        return examD;
    }

    public void setExamD(String examD) {
        this.examD = examD;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public class User{
        private String name;
        private String sex;
        private String age;
        private String cardId;
        private String personTel;
        private String currentAddress;
        private String personCode;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getPersonTel() {
            return personTel;
        }

        public void setPersonTel(String personTel) {
            this.personTel = personTel;
        }

        public String getCurrentAddress() {
            return currentAddress;
        }

        public void setCurrentAddress(String currentAddress) {
            this.currentAddress = currentAddress;
        }

        public String getPersonCode() {
            return personCode;
        }

        public void setPersonCode(String personCode) {
            this.personCode = personCode;
        }
    }
    public class Body{
        private String leftSbp;
        private String leftDbp;
        private String rightSbp;
        private String rightDbp;
        private String heartRate;
        private String waistline;
        private String ecg;
        private String ecgExcepion;
        private String bultrasonicOther;
        private String bultrasonicOtherException;
        private String otherBultrasound;
        private String otherBultrasoundException;
        private String chestXRay;
        private String chestXRayException;

        public String getLeftSbp() {
            return leftSbp;
        }

        public void setLeftSbp(String leftSbp) {
            this.leftSbp = leftSbp;
        }

        public String getLeftDbp() {
            return leftDbp;
        }

        public void setLeftDbp(String leftDbp) {
            this.leftDbp = leftDbp;
        }

        public String getRightSbp() {
            return rightSbp;
        }

        public void setRightSbp(String rightSbp) {
            this.rightSbp = rightSbp;
        }

        public String getRightDbp() {
            return rightDbp;
        }

        public void setRightDbp(String rightDbp) {
            this.rightDbp = rightDbp;
        }

        public String getHeartRate() {
            return heartRate;
        }

        public void setHeartRate(String heartRate) {
            this.heartRate = heartRate;
        }

        public String getWaistline() {
            return waistline;
        }

        public void setWaistline(String waistline) {
            this.waistline = waistline;
        }

        public String getEcg() {
            return ecg;
        }

        public void setEcg(String ecg) {
            this.ecg = ecg;
        }

        public String getEcgExcepion() {
            return ecgExcepion;
        }

        public void setEcgExcepion(String ecgExcepion) {
            this.ecgExcepion = ecgExcepion;
        }

        public String getBultrasonicOther() {
            return bultrasonicOther;
        }

        public void setBultrasonicOther(String bultrasonicOther) {
            this.bultrasonicOther = bultrasonicOther;
        }

        public String getBultrasonicOtherException() {
            return bultrasonicOtherException;
        }

        public void setBultrasonicOtherException(String bultrasonicOtherException) {
            this.bultrasonicOtherException = bultrasonicOtherException;
        }

        public String getOtherBultrasound() {
            return otherBultrasound;
        }

        public void setOtherBultrasound(String otherBultrasound) {
            this.otherBultrasound = otherBultrasound;
        }

        public String getOtherBultrasoundException() {
            return otherBultrasoundException;
        }

        public void setOtherBultrasoundException(String otherBultrasoundException) {
            this.otherBultrasoundException = otherBultrasoundException;
        }

        public String getChestXRay() {
            return chestXRay;
        }

        public void setChestXRay(String chestXRay) {
            this.chestXRay = chestXRay;
        }

        public String getChestXRayException() {
            return chestXRayException;
        }

        public void setChestXRayException(String chestXRayException) {
            this.chestXRayException = chestXRayException;
        }
    }
}
