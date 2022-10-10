package com.demo.test;

public class TestDTO {

    private TcmtcmQuestionnaireDTO tcmQuestionnaireDTO;

    private ConstitutionDataDto constitutionDataDto;

    public static class TcmtcmQuestionnaireDTO {
        private String data1;
        private String data11;

        public String getData1() {
            return data1;
        }

        public void setData1(String data1) {
            this.data1 = data1;
        }

        public String getData11() {
            return data11;
        }

        public void setData11(String data11) {
            this.data11 = data11;
        }
    }
    public static class ConstitutionDataDto {
        private String data2;
        private String data22;

        public String getData2() {
            return data2;
        }

        public void setData2(String data2) {
            this.data2 = data2;
        }

        public String getData22() {
            return data22;
        }

        public void setData22(String data22) {
            this.data22 = data22;
        }
    }

    public TcmtcmQuestionnaireDTO gettcmQuestionnaireDTO() {
        return tcmQuestionnaireDTO;
    }

    public void setTcmQuestionnaireDTO(TcmtcmQuestionnaireDTO tcmQuestionnaireDTO) {
        this.tcmQuestionnaireDTO = tcmQuestionnaireDTO;
    }

    public ConstitutionDataDto getConstitutionDataDto() {
        return constitutionDataDto;
    }

    public void setConstitutionDataDto(ConstitutionDataDto constitutionDataDto) {
        this.constitutionDataDto = constitutionDataDto;
    }

}
