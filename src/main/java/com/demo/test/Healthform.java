package com.demo.test;

public class Healthform {

    private static final String BULTRASONIC_EXCEPTION_FORMATTER = "腹部B超异常:%s;";
    private final static String ECG_EXCEPTION_FORMATTER = "心电图异常:%s;";
    private final static float BODYTEMPERATURE_MIN = 30.0F;
    private final static float BODYTEMPERATURE_MAX = 45.0F;
    private final static int PULSE_RATE_MIN = 40;
    private final static int PULSE_RATE_MAX = 200;
    private final static int RESPIRATORY_RATE_MIN = 15;
    private final static int RESPIRATORY_RATE_MAX = 200;
    private final static int SBP_MIN = 15;
    private final static int SBP_MAX = 200;
    private final static int DBP_MIN = 15;
    private final static int DBP_MAX = 200;
    private final static float HEMOGLOBIN_MIN = 0.00F;
    private final static float HEMOGLOBIN_MAX = 250.00F;
    private final static float LEUKOCYTE_MIN = 0.00F;
    private final static float LEUKOCYTE_MAX = 9999.00F;
    private final static float PLATELET_MIN = 0.00F;
    private final static float PLATELET_MAX = 9999.00F;
    private final static float GLUCOSE_MIN = 0.00F;
    private final static float GLUCOSE_MAX = 100.00F;
    private final static float UA_MIN = 0.00F;
    private final static float UA_MAX = 9999.00F;
    private final static float HEIGHT_MIN = 10.0F;
    private final static float HEIGHT_MAX = 300.0F;
    private final static float WEIGHT_MIN = 2.0F;
    private final static float WEIGHT_MAX = 300.0F;
    private final static float WAISTLINE_MIN = 1.0F;
    private final static float WAISTLINE_MAX = 200.0F;
    private final static int TIME_MIN = 0;
    private final static int TIME_MAX = 999;
    private final static int TEETH_MIN = 0;
    private final static int TEETH_MAX = 99;
    private final static float EYE_MIN = 0.0F;
    private final static float EYE_MAX = 5.3F;
    private final static int HEART_RATE_MIN = 10;
    private final static int HEART_RATE_MAX = 200;
    private final static int EXERCISE_METHOD_LENGTH = 25;
    private final static int SMOKING_MIN = 0;
    private final static int SMOKING_MAX = 999;
    private final static int ALCOHOL_TYPE_OTHER_LENGTH = 25;
    private final static int DUST_NAME_LENGTH = 25;
    private final static int OCCUPATION_LENGTH = 25;
    private final static int DENTITION_STATUS_2 = 2;
    private final static int DENTITION_STATUS_4 = 4;
    private final static int DENTITION_STATUS_8 = 8;
    private final static String QUOT = ";";
    private final static String NO_EXERCISE_FREQUENCY = "8";
    private final static String NERVEROUS_SYSTEM_STATUS_2 = "2";
    private final static String OTHER_ILLNESS_STATUS_2 = "2";
    private final static String IS_OE_STATUS_2 = "2";
    private final static String DUST_PROTECTION_STATUS_2 = "2";
    private final static String RADIO_PROTECTION_STATUS_2 = "2";
    private final static String PHYSICS_STATUS_2 = "2";
    private final static String CHEMISTRY_STATUS_2 = "2";
    private final static String OTHER_POISION_STATUS_2 = "2";
    private final static String SMOKING_STATUS_1 = "1";
    private final static String SMOKING_STATUS_2 = "2";
    public final static String SMOKING_STATUS_4 = "4";
    public final static String DRINK_STATUS_1 = "1";
    public final static String ISALCOHOL_STATUS_1 = "1";
    private final static String ISALCOHOL_STATUS_2 = "2";
    private final static String ASSESSMENT_STATUS_2 = "2";
    private final static String SKIN_STATUS_64 = "64";
    private final static String SCLERA_STATUS_8 = "8";
    private final static String LYMPHNODES_STATUS_8 = "8";
    private final static String BREATHSOUNDS_STATUS_2 = "2";
    private final static String RALE_STATUS_8 = "8";
    private final static String HEART_MURMUR_STATUS_2 = "2";
    private final static String ABDOMINAL_TENDERNESS_STATUS_2 = "2";
    private final static String ABDOMINA_MASS_STATUS_2 = "2";
    private final static String LIVER_STATUS_2 = "2";
    private final static String SPLENOMEGALY_STATUS_2 = "2";
    private final static String SHIFTDULLNESS_STATUS_2 = "2";
    private final static String IS_OE_1 = "1";
    private final static String FUNDS_1 = "1";
    private final static String SKIN_OTHER = "64";
    private final static String SCLERA_OTHER = "8";
    private final static String LYMPHNODES_OTHER = "8";
    private final static String BREATHSOUNDS_OTHER = "2";
    private final static String RALE_OTHER = "8";
    private final static String HEARTMUEMUR_OTHER = "2";
    private final static String ABDOMINALTENDERNESS_OTHER = "2";
    private final static String ABDOMINAMASS_OTHER = "2";
    private final static String ABDOMENLIVER_OTHER = "2";
    private final static String SPLENOMEGALY_OTHER = "2";
    private final static String SHIFTINGDULLNESS_OTHER = "2";
    private final static String VULVA_OTHER = "2";
    private final static String VAGINAL_OTHER = "2";
    private final static String CERVIX_OTHER = "2";
    private final static String PALACE_OTHER = "2";
    private final static String UTERINEADNEXA_OTHER = "2";
    private final static String ECG_OTHER = "2";
    private final static String CHESTXRAY_OTHER = "2";
    private final static String BULTRASONICOTHER_OTHER = "2";
    private final static String OTHERBULTRASOUND_OTHER = "2";
    private final static String CERVICALSMEAR_OTHER = "2";
    private final static String NERVOUSSYSTEM_OTHER = "2";
    private final static String OTHERILLNESS_OTHER = "2";
    private final static int SMPTOM_OTHER = 16777216;
    private final static int CEREBROVASCULAR_OTHER = 32;
    private final static int KIDNEY_OTHER = 32;
    private final static int HEART_OTHER = 64;
    private final static int VASCULAR_OTHER = 8;
    private final static int EYES_OTHER = 16;
    public final static int LOG = 1;
    public final static int NORMAL = 2;
    private final static String MT = "缺齿";
    private final static String CARI = "龋齿";
    private final static String DENTURE = "义齿";
    public static final String YCXY = "右侧血压";
    public static final String ZCXY = "左侧血压";
    public static final String MAILV = "脉率";
    public static final float MAILV_MAX = 100F;
    public static final float MAILV_MIN = 60F;
    public static final String MAILV_MAX_DESC = "脉率过快";
    public static final String MAILV_MIN_DESC = "脉率过慢";
    public static final String MAILV_UNIT = "次/分钟";
    public static final String HXPL = "呼吸频率";
    public static final float HXPL_MAX = 20F;
    public static final float HXPL_MIN = 16F;
    public static final String HXPL_MAX_DESC = "呼吸频率过快";
    public static final String HXPL_MIN_DESC = "呼吸频率过慢";
    public static final String HXPL_UNIT = "次/分钟";
    public static final String TZ = "体重";
    public static final String EXERCISE = "运动不足";
    public static final String SMOKE = "吸烟";
    public static final String DRINK = "喝酒";
    public static final float TZ_MAX = 28F;
    public static final float TZ_CENTER = 24F;
    public static final float TZ_MIN = 18.5F;
    public static final String TZ_MAX_DESC = "体重肥胖";
    public static final String TZ_MIN_DESC = "体重消瘦";
    public static final String TZ_CENTER_DESC = "体重超重";
    public final static String TZ_UNIT = "kg/m2";
    public static final String XHDB = "贫血";
    public static final String WAISTLINE = "中心型肥胖";
    public static final float XHDB_MAX = 160F;
    public static final float XHDB_MIN = 110F;
    public static final String XHDB_MAX_DESC = "血红蛋白含量过高";
    public static final String XHDB_MIN_DESC = "血红蛋白含量过低";
    public static final String XHDB_UNIT = "(g/L)";
    public static final String XXB = "血小板";
    public static final float XXB_MAX = 400F;
    public static final float XXB_MIN = 80F;
    //    public static final String XXB_MAX_DESC = "血小板含量过高";
//    public static final String XXB_MIN_DESC = "血小板含量过低";
    public static final String XXB_MAX_DESC = "血小板异常";
    public static final String XXB_MIN_DESC = "血小板异常";
    public static final String XXB_UNIT = "(10^9/L)";
    public static final String BXB = "白细胞";
    public static final float BXB_VALUE = 12.0F;
    public static final float BXB_MAX = 10.0F;
    public static final float BXB_MIN = 4.0F;
    public static final String BXB_MAX_DESC = "白细胞含量过高";
    public static final String BXB_MIN_DESC = "白细胞含量过低";
    public static final String BXB_UNIT = "(10^9/L)";
    public static final String XDT = "心电图异常";
    public static final String XDT_VALUE = "2";
    public static final String BC = "其他B超异常";
    public static final String FBBC = "腹部B超异常";
    public static final String KFXT = "血糖";
    public static final String KFXT_UNIT = "(mmol/L)";
    public static final float KFXT_MAX = 6.11F;
    public static final float KFXT_MIN = 3.89F;
    public static final String KFXT_MAX_DESC = "空腹血糖过高";
    public static final String KFXT_MIN_DESC = "空腹血糖过低";
    public static final String XQGBZAM = "肝功异常";
    public static final float XQGBZAM_MAX = 40F * 2;
    public static final String XQGBZAM_DESC = "肝功异常";
    public static final String XQGBZAM_UNIT = "(u/L)";
    public static final String XQGCZAM = "肝功异常";
    public static final float XQGCZAM_MAX = 40F * 2;
    public static final String XQGCZAM_DESC = "肝功异常";
    public static final String XQGCZAM_UNIT = "(u/L)";
    public static final String ZDHS = "总胆红素";
    public static final float ZDHS_MAX = 28F;
    public static final float ZDHS_MIN = 5.1F;
    public static final String ZDHS_MAX_DESC = "总胆红素含量含量过高";
    public static final String ZDHS_MIN_DESC = "总胆红素含量含量过低";
    public static final String ZDHS_UNIT = "(u/L)";
    public static final String XQJG = "肾功异常";
    public static final float XQJG_MAX = 106F * 2;
    public static final String XQJG_DESC = "肾功异常";
    public static final String XQJG_UNIT = "(μmol/L)";
    public static final String XNSD = "肾功异常";
    public static final float XNSD_MAX = 7.2F * 2;
    public static final String XNSD_DESC = "肾功异常";
    public static final String XNSD_UNIT = "(u/L)";
    public static final String ZDGC = "总胆固醇";
    public static final float ZDGC_MAX = 5.2F;
    public static final float ZDGC_MIN = 0F;
    public static final String ZDGC_MAX_DESC = "总胆固醇过高";
    public static final String ZDGC_MIN_DESC = "总胆固醇过低";
    public static final String ZDGC_UNIT = "(mmol/L)";
    public static final String GYSZ = "甘油三酯";
    public static final String GYSZV2 = "高甘油三酯血症";
    public static final String GXZZ = "高血脂症";
    public static final float GYSZ_MAX = 2.3F;
    public static final float GYSZ_MIN = 0F;
    public static final String GYSZ_MAX_DESC = "甘油三酯过高";
    public static final String GYSZ_MIN_DESC = "甘油三酯过低";
    public static final String GYSZ_UNIT = "(mmol/L)";
    public static final String NDB = "尿蛋白";
    public static final String NT = "尿糖";
    public static final String NTT = "尿酮体";
    public static final String NQX = "尿潜血";
    public final static String URINE_PROTEIN_EXCEPTION = "尿蛋白(PRO)异常";
    public final static String URINE_EXCEPTION = "尿糖(GLU)异常";
    public final static String KETONE_EXCEPTION = "尿酮体(KET)异常";
    public final static String OCCULTBLOODINURINE_EXCEPTION = "尿潜血(BLO)异常";
    private final static float BMI_FAT = 24F;
    public final static float WAISTLINE_MALE_LIMIT = 90F;
    public final static float WAISTLINE_FEMALE_LIMIT = 85F;
    public final static String WAISTLINE_EXCEPTION = "中心型肥胖者(腹型肥胖) 腰围:";
    public final static String CM = "cm";
    public final static String MARK = ",.!;:，。；：！";
    private final static String RISK_WAISLINE = "腰围过高，控制饮食";
    public final static String EXCEPTION_FORMAT = "异常%s：";
    private static final String PATTERN = "异常\\d+(：|:)";
    private final static String ENTERV1 = "\\\\n";

    private String planId;
    private Integer id;
    /**
     * 空代表新增;非空代表编辑
     */
    private String mtId;
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 服务ID(编辑的时候需要传这个值)
     */
    private String serviceId = "";
    /**
     * 备注
     */
    private String remark;
    /**
     * 复查记录
     */
    private String record;
    /**
     * 0代表未完善，1代表数据完善
     */
    private Integer completeFlag;
    /**
     * 未完善时对应的信息，完善时为空
     */
    private String completeMessage;
    /**
     * 登记人
     */
    private String registerId;
    /**
     * 登记时间
     */
    private String registerDate;
    /**
     * 编辑时间
     */
    private String editDate;
    /**
     * 修改版次
     */
    private String editVersion;
    /**
     * 数据标识
     */
    private String dataFlag;
    /**
     * EX电话
     */
    private String exPhone;
    /**
     * EX地址
     */
    private String exAddress;
    /**
     * 宣教内容
     */
    private String xjContent;
    /**
     * 体检类型
     */
    private String healthformType;
    /**
     * 癌胚抗原
     */
    private String carcinoEmbryonicAntigen;
    /**
     * 甲胎蛋白
     */
    private String afp;
    /**
     * 编号
     */
    private String personNO;
    /**
     * 姓名
     */
    private String name;
    /**
     * 体检日期
     */
    private String examDate;
    /**
     * 责任医生ID
     */
    private String responsibleDoctorId;
    /**
     * 责任医生
     */
    private String responsibleDoctorName;
    /**
     * 症状(1248相加)
     */
    private String symptom;
    /**
     * 症状其他
     */
    private String symptomOther;
    /**
     * 体温
     */
    private String bodyTemperature;
    /**
     * 脉搏
     */
    private String pulseRate;
    /**
     * 呼吸频率
     */
    private String respiratoryRate;
    /**
     * 舒张压
     */
    private String leftDbp;
    /**
     * 收缩压
     */
    private String leftSbp;
    /**
     * 舒张压右
     */
    private String rightDbp;
    /**
     * 收缩压右
     */
    private String rightSbp;
    /**
     * 身高
     */
    private String height;
    /**
     * 体重
     */
    private String weight;
    /**
     * 腰围
     */
    private String waistline;
    /**
     * 体质指数
     */
    private String bmi;
    /**
     * 老年人健康状态评估
     */
    private String health;
    /**
     * 老年人生活自理评分(Web端的老年人生活自理能力自我评估)
     */
    private String lifeSkillsScore;
    /**
     * 老年人认知功能
     */
    private String cognitiveFunction;
    /**
     * 老年人认知功能总分
     */
    private String cognitiveFunctionScore;
    /**
     * 老年人情感状态
     */
    private String emotionalState;
    /**
     * 老年人情感状态总分
     */
    private String emotionalStateScore;
    /**
     * 锻炼频率(1248单选)
     */
    private String exerciseFrequency;
    /**
     * 每次锻炼时间
     */
    private String eachExerciseTime;
    /**
     * 坚持锻炼时间
     */
    private String exerciseTime;
    /**
     * 锻炼方式
     */
    private String exerciseMethod;
    /**
     * 饮食习惯
     */
    private String diet;
    /**
     * 吸烟状况(1248单选)
     */
    private String smokingStatus;
    /**
     * 日吸烟量
     */
    private String smoking;
    /**
     * 开始吸烟年龄
     */
    private String smokingAge;
    /**
     * 戒烟年龄
     */
    private String ageQuit;
    /**
     * 饮酒频率(1248单选)
     */
    private String drinkingFrequency;
    /**
     * 日饮酒量
     */
    private String dailyAlcoholIntake;
    /**
     * 是否戒酒(1248单选)
     */
    private String isAlcohol;
    /**
     * 戒酒年龄
     */
    private String alcoholAge;
    /**
     * 开始饮酒年龄
     */
    private String ageStartedDrinking;
    /**
     * 近一年是否醉酒
     */
    private String isDrunkLastYear;
    /**
     * 饮酒种类
     */
    private String alcoholType;
    /**
     * 饮酒其他
     */
    private String alcoholTypeOther;
    /**
     * 职业病危害接触(12单选)
     */
    private String isOe;
    /**
     * 职业工种
     */
    private String occupation;
    /**
     * 职业从业时间
     */
    private String workingTime;
    /**
     * 粉尘名称
     */
    private String dustName;
    /**
     * 粉尘防护
     */
    private String dustProtection;
    /**
     * 粉尘防护措施
     */
    private String dustProtectionDetail;
    /**
     * 放射物质名称
     */
    private String radioName;
    /**
     * 放射物质防护
     */
    private String radioProtection;
    /**
     * 放射物质防护措施
     */
    private String radioProtectionDetail;
    /**
     * 物理因素名称
     */
    private String physicsName;
    /**
     * 物理因素防护
     */
    private String physicsProtection;
    /**
     * 物理因素防护措施
     */
    private String physicsProtectionDetail;
    /**
     * 化学物质名称
     */
    private String chemistryName;
    /**
     * 化学物质防护
     */
    private String chemistryProtection;
    /**
     * 化学物质防护措施
     */
    private String chemistryProtectionDetail;
    /**
     * 其他毒物名称
     */
    private String otherPoision;
    /**
     * 其他毒物防护
     */
    private String otherPoisionProtection;
    /**
     * 其他毒物防护措施
     */
    private String otherPoisionProtectionDetail;
    /**
     * 口唇
     */
    private String lips;
    /**
     * 齿列
     */
    private String dentition;
    /**
     * 是否缺齿
     */
    private String missingTeeth;
    /**
     * 缺齿左上
     */
    private String missingTeethLT;
    /**
     * 缺齿右上
     */
    private String missingTeethRT;
    /**
     * 缺齿左下
     */
    private String missingTeethLB;
    /**
     * 缺齿右下
     */
    private String missingTeethRB;
    /**
     * 是否龋齿
     */
    private String caries;
    /**
     * 龋齿左上
     */
    private String cariesLT;
    /**
     * 龋齿右上
     */
    private String cariesRT;
    /**
     * 龋齿左下
     */
    private String cariesLB;
    /**
     * 龋齿右下
     */
    private String cariesRB;
    /**
     * 是否义齿
     */
    private String denture;
    /**
     * 义齿左上
     */
    private String dentureLT;
    /**
     * 义齿右上
     */
    private String dentureRT;
    /**
     * 义齿左下
     */
    private String dentureLB;
    /**
     * 义齿右下
     */
    private String dentureRB;
    /**
     * 咽部
     */
    private String throat;
    /**
     * 左眼视力
     */
    private String leftEye;
    /**
     * 右眼视力
     */
    private String rightEye;
    /**
     * 矫正左眼视力
     */
    private String leftEyeVc;
    /**
     * 矫正右眼视力
     */
    private String rightEyeVc;
    /**
     * 听力
     */
    private String hearing;
    /**
     * 听力描述
     */
    private String hearingDesc;
    /**
     * 运动功能
     */
    private String motorFunction;
    /**
     * 眼底
     */
    private String fundus;
    /**
     * 眼底异常
     */
    private String fundusException;
    /**
     * 皮肤(1248单选)
     */
    private String skin;
    /**
     * 皮肤异常
     */
    private String skinException;
    /**
     * 巩膜
     */
    private String sclera;
    /**
     * 巩膜其他
     */
    private String scleraOther;
    /**
     * 淋巴结
     */
    private String lymphNodes;
    /**
     * 淋巴结其他
     */
    private String lymphNodesOther;
    /**
     * 桶状胸
     */
    private String barrelChest;
    /**
     * 呼吸音
     */
    private String breathSounds;
    /**
     * 呼吸音异常
     */
    private String breathSoundsException;
    /**
     * 罗音
     */
    private String rale;
    /**
     * 罗音其他
     */
    private String raleOther;
    /**
     * 心律
     */
    private String rhythm;
    /**
     * 心率
     */
    private String heartRate;
    /**
     * 是否杂音
     */
    private String heartMurmur;
    /**
     * 杂音描述
     */
    private String heartMurmurDesc;
    /**
     * 是否压痛
     */
    private String abdominalTenderness;
    /**
     * 压痛描述
     */
    private String abdominalTendernessDesc;
    /**
     * 是否包块
     */
    private String abdominaMass;
    /**
     * 包块描述
     */
    private String abdominaMassDesc;
    /**
     * 是否肝大
     */
    private String theAbdomenLiver;
    /**
     * 肝大描述
     */
    private String theAbdomenLiverDesc;
    /**
     * 是否脾大
     */
    private String splenomegaly;
    /**
     * 脾大描述
     */
    private String splenomegalyDesc;
    /**
     * 是否移动浊音
     */
    private String shiftingDullness;
    /**
     * 移动浊音描述
     */
    private String shiftingDullnessDesc;
    /**
     * 下肢水肿
     */
    private String lowerExtremityEdema;
    /**
     * 足背动脉搏动
     */
    private String dorsalisPedisArteryPulse;
    /**
     * 肛门指诊
     */
    private String dre;
    /**
     * 肛门指诊其他
     */
    private String dreOther;
    /**
     * 乳腺
     */
    private String breast;
    /**
     * 乳腺其他
     */
    private String breastOther;
    /**
     * 外阴
     */
    private String vulva;
    /**
     * 外阴异常
     */
    private String vulvaException;
    /**
     * 阴道
     */
    private String vaginal;
    /**
     * 阴道异常
     */
    private String vaginalException;
    /**
     * 宫颈
     */
    private String cervix;
    /**
     * 宫颈异常
     */
    private String cervixException;
    /**
     * 宫体
     */
    private String palace;
    /**
     * 宫体异常
     */
    private String palaceException;
    /**
     * 附件
     */
    private String uterineAdnexa;
    /**
     * 附件异常
     */
    private String uterineAdnexaException;
    /**
     * 查体其他
     */
    private String physicalOther;
    /**
     * 血红蛋白
     */
    private String hemoglobin;
    /**
     * 白细胞
     */
    private String leukocyte;
    /**
     * 血小板
     */
    private String platelet;
    /**
     * 血常规其他
     */
    private String otherBlood;
    /**
     * 尿蛋白
     */
    private String urineProtein;
    /**
     * 尿糖
     */
    private String urine;
    /**
     * 尿酮体
     */
    private String ketone;
    /**
     * 尿潜血
     */
    private String occultBloodInUrine;
    /**
     * 尿常规其他
     */
    private String otherUrine;
    /**
     * 空腹血糖
     */
    private String fastingBloodGlucose;
    /**
     * 空腹血糖MG
     */
    private String randomBloodGlucose;
    /**
     * 餐后血糖
     */
    private String postprandialBloodGlucose;
    /**
     * 心电图
     */
    private String ecg;
    /**
     * 心电图异常
     */
    private String ecgExcepion;
    /**
     * 尿微量白蛋白
     */
    private String urinaryAlbumin;
    /**
     * 大便潜血
     */
    private String fecalOccultBlood;
    /**
     * 糖化血红蛋白
     */
    private String glycatedHemoglobin;
    /**
     * 乙型肝炎表面抗原
     */
    private String hepatitisBSurfaceAntigen;
    /**
     * 血清谷丙转氨酶
     */
    private String serumAla;
    /**
     * 血清谷草转氨酶
     */
    private String serumAa;
    /**
     * 白蛋白
     */
    private String albumin;
    /**
     * 总胆红素
     */
    private String totalBilirubin;
    /**
     * 结合胆红素
     */
    private String bilirubin;
    /**
     * 血清肌酐
     */
    private String serumCreatinine;
    /**
     * 血尿素氮
     */
    private String bun;
    /**
     * 血钾浓度
     */
    private String potassiumConcentration;
    /**
     * 血钠浓度
     */
    private String sodiumConcentration;
    /**
     * 总胆固醇
     */
    private String totalCholesterol;
    /**
     * 甘油三酯
     */
    private String triglycerides;
    /**
     * 血清低脂胆固醇
     */
    private String ldlCholesterol;
    /**
     * 血清高脂胆固醇
     */
    private String hdlCholesterol;
    /**
     * 胸部X线片
     */
    private String chestXRay;
    /**
     * 胸部X线片异常
     */
    private String chestXRayException;
    /**
     * 腹部B超
     */
    private String bultrasonicOther;
    /**
     * 腹部B超异常
     */
    private String bultrasonicOtherException;
    /**
     * 其他B超
     */
    private String otherBultrasound;
    /**
     * 其他B超异常
     */
    private String otherBultrasoundException;
    /**
     * 宫颈涂片
     */
    private String cervicalSmear;
    /**
     * 宫颈涂片异常
     */
    private String cervicalSmearException;
    /**
     * 辅助检查其他
     */
    private String otherLaboratory;
    /**
     * 体质类型
     */
    private String constitutionType;
    /**
     * 脑血管疾病(1248相加)
     */
    private String cerebrovascular;
    /**
     * 脑血管疾病其他
     */
    private String cerebrovascularOther;
    /**
     * 肾脏疾病(1248相加)
     */
    private String kidney;
    /**
     * 肾脏疾病其他
     */
    private String kidneyOther;
    /**
     * 心脏疾病(1248相加)
     */
    private String heart;
    /**
     * 心脏疾病其他
     */
    private String heartOther;
    /**
     * 血管疾病(1248相加)
     */
    private String vascular;
    /**
     * 血管疾病其他
     */
    private String vascularOther;
    /**
     * 眼部疾病(1248相加)
     */
    private String eyes;
    /**
     * 眼部疾病其他
     */
    private String eyesOther;
    /**
     * 神经系统疾病(1248单选)
     */
    private String nervoussystems;
    /**
     * 神经系统疾病输入框
     */
    private String nervousIllness;
    /**
     * 是否其他系统疾病(1248单选)
     */
    private String otherIllness;
    /**
     * 其他系统疾病
     */
    private String otherIllnessValue;
    /**
     * 健康评价
     */
    private String assessment;
    /**
     * 健康评价详细
     */
    private String assessmentAbnormal;
    /**
     * 健康指导
     */
    private String guidance;
    /**
     * 建议复查标记字段，不需要设置值
     */
    private String reCheck;
    /**
     * 健康指导其他
     */
    private String guidanceOther;
    /**
     * 危险因素控制
     */
    private String riskCrtl;
    /**
     * 体重控制
     */
    private String riskCrtlWeight;
    /**
     * 建议接种疫苗
     */
    private String riskCrtlVaccine;
    /**
     * 危险因素控制其他
     */
    private String riskCrtlOther;
    /**
     * 项目ID(getAvailableService接口中的itemId字段)
     */
    private String projectId;
    /**
     * 原型ID(编辑的时候需要传这个值)
     */
    private String prototypeId = "";
    /**
     * 机构ID
     */
    private String orgId;
    /**
     * 个人ID
     */
    private String personId;
    /**
     * 身份证
     */
    private String cardId;
    /**
     * 健康教育
     */
    private String healthEducation;
    /**
     * B超描述
     */
    private String ultrasonicDesc;
    /**
     * B超提示
     */
    private String ultrasonicTips;
    /**
     * ls(life skill)服务名称
     */
    private String lsServiceName;
    /**
     * ls(life skill)ID
     */
    private String lsId;
    /**
     * ls(life skill)服务ID
     */
    private String lsServiceId;
    /**
     * ls(life skill)原型ID
     */
    private String lsPrototypeId;
    /**
     * ls(life skill)机构ID
     */
    private String lsOrgId;
    /**
     * ls(life skill)个人ID
     */
    private String lsPersonId;
    /**
     * ls(life skill)编号
     */
    private String lsNumber;
    /**
     * ls(life skill)姓名
     */
    private String lsName;
    /**
     * ls(life skill)进餐
     */
    private String lsMeal;
    /**
     * ls(life skill)梳洗
     */
    private String lsCleanup;
    /**
     * ls(life skill)穿衣
     */
    private String lsDressup;
    /**
     * ls(life skill)如厕
     */
    private String lsToilet;
    /**
     * ls(life skill)活动
     */
    private String lsActivity;
    /**
     * ls(life skill老年人生活自理能力自我评估的得分)总分
     */
    private String lsScore;
    /**
     * ls(life skill)随访日期
     */
    private String lsFollowupDate;
    /**
     * ls(life skill)随访医生ID
     */
    private String lsDoctorId;
    /**
     * ls(life skill)随访医生
     */
    private String lsDoctorName;
    /**
     * ls(life skill)登记人
     */
    private String lsRegisterId;
    /**
     * ls(life skill)登记时间
     */
    private String lsRegisterDate;
    /**
     * ls(life skill)编辑时间
     */
    private String lsEditDate;
    /**
     * ls(life skill)修改版本
     */
    private String lsVersion;
    /**
     * ls(life skill)数据标识
     */
    private String lsFlag;
    /**
     * 1代表日志形式2代表真正业务数据
     */
    private Integer flag;
    /**
     * 体检地址名称
     */
    private String locationName;
    /**
     * 签名url
     */
    private String signatureUrl;
    /**
     * 老年人自理评估签名url
     */
    private String signatureUrlOld;
    /**
     * 经度
     */
    private String latitude;
    /**
     * 维度
     */
    private String longitude;
    private String region;

    /**
     * 1代表从我们系统增加的2代表是中联平台增加的 3 离线  4软服推送
     */

    public String getSignatureUrlOld() {
        return signatureUrlOld;
    }

    public void setSignatureUrlOld(String signatureUrlOld) {
        this.signatureUrlOld = signatureUrlOld;
    }



    public String getSignatureUrl() {
        return signatureUrl;
    }

    public void setSignatureUrl(String signatureUrl) {
        this.signatureUrl = signatureUrl;
    }

    public String getHealthEducation() {
        return healthEducation;
    }

    public void setHealthEducation(String healthEducation) {
        this.healthEducation = healthEducation;
    }


    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(Integer completeFlag) {
        this.completeFlag = completeFlag;
    }

    public String getCompleteMessage() {
        return completeMessage;
    }

    public void setCompleteMessage(String completeMessage) {
        this.completeMessage = completeMessage;
    }


    private void clearFund() {
        if (FUNDS_1.equals(fundus)) {
            // 眼底选择无异常时，将眼底异常置空
            fundusException = "";
        }
    }

    private void clearOe() {
        if (IS_OE_1.equals(isOe)) {
            // 职业病危害史选择无
            // 工种
            occupation = "";
            // 职业从业时间
            workingTime = "";
            // 粉尘名称
            dustName = "";
            // 粉尘防护
            dustProtection = "";
            // 粉尘防护措施
            dustProtectionDetail = "";
            // 放射物质名称
            radioName = "";
            // 放射物质防护
            radioProtection = "";
            // 放射物质防护措施
            radioProtectionDetail = "";
            // 物理因素名称
            physicsName = "";
            // 物理因素防护
            physicsProtection = "";
            // 物理因素防护措施
            physicsProtectionDetail = "";
            // 化学物质名称
            chemistryName = "";
            // 化学物质防护
            chemistryProtection = "";
            // 化学物质防护措施
            chemistryProtectionDetail = "";
            // 其他毒物名称
            otherPoision = "";
            // 其他毒物防护
            otherPoisionProtection = "";
            // 其他毒物防护措施
            otherPoisionProtectionDetail = "";
        }
    }

    private void clearSmokeQuit() {
        if (SMOKING_STATUS_4.equals(smokingStatus)) {
            ageQuit = "";
        }
    }

    private void clearSmoke() {
        if (SMOKING_STATUS_1.equals(smokingStatus)) {
            smoking = "";
            smokingAge = "";
            ageQuit = "";
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMtId() {
        return mtId;
    }

    public void setMtId(String mtId) {
        this.mtId = mtId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getNervousIllness() {
        return nervousIllness;
    }

    public void setNervousIllness(String nervousIllness) {
        this.nervousIllness = nervousIllness;
    }

    public String getOtherIllness() {
        return otherIllness;
    }

    public void setOtherIllness(String otherIllness) {
        this.otherIllness = otherIllness;
    }

    public String getOtherIllnessValue() {
        return otherIllnessValue;
    }

    public void setOtherIllnessValue(String otherIllnessValue) {
        this.otherIllnessValue = otherIllnessValue;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }



    public String getAssessmentAbnormal() {
        return assessmentAbnormal;
    }

    public void setAssessmentAbnormal(String assessmentAbnormal) {
        this.assessmentAbnormal = assessmentAbnormal;
    }


    public String getGuidance() {
        return guidance;
    }

    public void setGuidance(String guidance) {
        this.guidance = guidance;
    }


    public String getGuidanceOther() {
        return guidanceOther;
    }

    public void setGuidanceOther(String guidanceOther) {
        this.guidanceOther = guidanceOther;
    }

    public String getRiskCrtl() {
        return riskCrtl;
    }

    public void setRiskCrtl(String riskCrtl) {
        this.riskCrtl = riskCrtl;
    }

    public String getRiskCrtlWeight() {
        return riskCrtlWeight;
    }

    public void setRiskCrtlWeight(String riskCrtlWeight) {
        this.riskCrtlWeight = riskCrtlWeight;
    }

    public String getRiskCrtlVaccine() {
        return riskCrtlVaccine;
    }

    public void setRiskCrtlVaccine(String riskCrtlVaccine) {
        this.riskCrtlVaccine = riskCrtlVaccine;
    }

    public String getRiskCrtlOther() {
        return riskCrtlOther;
    }

    public void setRiskCrtlOther(String riskCrtlOther) {
        this.riskCrtlOther = riskCrtlOther;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public String getEditVersion() {
        return editVersion;
    }

    public void setEditVersion(String editVersion) {
        this.editVersion = editVersion;
    }

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
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

    public String getExPhone() {
        return exPhone;
    }

    public void setExPhone(String exPhone) {
        this.exPhone = exPhone;
    }

    public String getExAddress() {
        return exAddress;
    }

    public void setExAddress(String exAddress) {
        this.exAddress = exAddress;
    }

    public String getHearing() {
        return hearing;
    }

    public void setHearing(String hearing) {
        this.hearing = hearing;
    }

    public String getHearingDesc() {
        return hearingDesc;
    }

    public void setHearingDesc(String hearingDesc) {
        this.hearingDesc = hearingDesc;
    }

    public String getXjContent() {
        return xjContent;
    }

    public void setXjContent(String xjContent) {
        this.xjContent = xjContent;
    }

    public String getHealthformType() {
        return healthformType;
    }

    public void setHealthformType(String healthformType) {
        this.healthformType = healthformType;
    }

    public String getCarcinoEmbryonicAntigen() {
        return carcinoEmbryonicAntigen;
    }

    public void setCarcinoEmbryonicAntigen(String carcinoEmbryonicAntigen) {
        this.carcinoEmbryonicAntigen = carcinoEmbryonicAntigen;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getLips() {
        return lips;
    }

    public void setLips(String lips) {
        this.lips = lips;
    }

    public String getDentition() {
        return dentition;
    }

    public void setDentition(String dentition) {
        this.dentition = dentition;
    }

    public String getMissingTeeth() {
        return missingTeeth;
    }

    public void setMissingTeeth(String missingTeeth) {
        this.missingTeeth = missingTeeth;
    }

    public String getMissingTeethLT() {
        return missingTeethLT;
    }

    public void setMissingTeethLT(String missingTeethLT) {
        this.missingTeethLT = missingTeethLT;
    }

    public String getMissingTeethRT() {
        return missingTeethRT;
    }

    public void setMissingTeethRT(String missingTeethRT) {
        this.missingTeethRT = missingTeethRT;
    }

    public String getMissingTeethLB() {
        return missingTeethLB;
    }

    public void setMissingTeethLB(String missingTeethLB) {
        this.missingTeethLB = missingTeethLB;
    }

    public String getMissingTeethRB() {
        return missingTeethRB;
    }

    public void setMissingTeethRB(String missingTeethRB) {
        this.missingTeethRB = missingTeethRB;
    }

    public String getCaries() {
        return caries;
    }

    public void setCaries(String caries) {
        this.caries = caries;
    }

    public String getCariesLT() {
        return cariesLT;
    }

    public void setCariesLT(String cariesLT) {
        this.cariesLT = cariesLT;
    }

    public String getCariesRT() {
        return cariesRT;
    }

    public void setCariesRT(String cariesRT) {
        this.cariesRT = cariesRT;
    }

    public String getCariesLB() {
        return cariesLB;
    }

    public void setCariesLB(String cariesLB) {
        this.cariesLB = cariesLB;
    }

    public String getCariesRB() {
        return cariesRB;
    }

    public void setCariesRB(String cariesRB) {
        this.cariesRB = cariesRB;
    }

    public String getDenture() {
        return denture;
    }

    public void setDenture(String denture) {
        this.denture = denture;
    }

    public String getDentureLT() {
        return dentureLT;
    }

    public void setDentureLT(String dentureLT) {
        this.dentureLT = dentureLT;
    }

    public String getDentureRT() {
        return dentureRT;
    }

    public void setDentureRT(String dentureRT) {
        this.dentureRT = dentureRT;
    }

    public String getDentureLB() {
        return dentureLB;
    }

    public void setDentureLB(String dentureLB) {
        this.dentureLB = dentureLB;
    }

    public String getDentureRB() {
        return dentureRB;
    }

    public void setDentureRB(String dentureRB) {
        this.dentureRB = dentureRB;
    }

    public String getThroat() {
        return throat;
    }

    public void setThroat(String throat) {
        this.throat = throat;
    }

    public String getLeftEye() {
        return leftEye;
    }

    public void setLeftEye(String leftEye) {
        this.leftEye = leftEye;
    }

    public String getRightEye() {
        return rightEye;
    }

    public void setRightEye(String rightEye) {
        this.rightEye = rightEye;
    }

    public String getLeftEyeVc() {
        return leftEyeVc;
    }

    public void setLeftEyeVc(String leftEyeVc) {
        this.leftEyeVc = leftEyeVc;
    }

    public String getRightEyeVc() {
        return rightEyeVc;
    }

    public void setRightEyeVc(String rightEyeVc) {
        this.rightEyeVc = rightEyeVc;
    }

    public String getMotorFunction() {
        return motorFunction;
    }

    public void setMotorFunction(String motorFunction) {
        this.motorFunction = motorFunction;
    }

    public String getFundus() {
        return fundus;
    }

    public void setFundus(String fundus) {
        this.fundus = fundus;
    }

    public String getFundusException() {
        return fundusException;
    }

    public void setFundusException(String fundusException) {
        this.fundusException = fundusException;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getSkinException() {
        return skinException;
    }

    public void setSkinException(String skinException) {
        this.skinException = skinException;
    }

    public String getSclera() {
        return sclera;
    }

    public void setSclera(String sclera) {
        this.sclera = sclera;
    }

    public String getScleraOther() {
        return scleraOther;
    }

    public void setScleraOther(String scleraOther) {
        this.scleraOther = scleraOther;
    }

    public String getLymphNodes() {
        return lymphNodes;
    }

    public void setLymphNodes(String lymphNodes) {
        this.lymphNodes = lymphNodes;
    }

    public String getLymphNodesOther() {
        return lymphNodesOther;
    }

    public void setLymphNodesOther(String lymphNodesOther) {
        this.lymphNodesOther = lymphNodesOther;
    }

    public String getBarrelChest() {
        return barrelChest;
    }

    public void setBarrelChest(String barrelChest) {
        this.barrelChest = barrelChest;
    }

    public String getBreathSounds() {
        return breathSounds;
    }

    public void setBreathSounds(String breathSounds) {
        this.breathSounds = breathSounds;
    }

    public String getBreathSoundsException() {
        return breathSoundsException;
    }

    public void setBreathSoundsException(String breathSoundsException) {
        this.breathSoundsException = breathSoundsException;
    }

    public String getRale() {
        return rale;
    }

    public void setRale(String rale) {
        this.rale = rale;
    }

    public String getRaleOther() {
        return raleOther;
    }

    public void setRaleOther(String raleOther) {
        this.raleOther = raleOther;
    }

    public String getRhythm() {
        return rhythm;
    }

    public void setRhythm(String rhythm) {
        this.rhythm = rhythm;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getHeartMurmur() {
        return heartMurmur;
    }

    public void setHeartMurmur(String heartMurmur) {
        this.heartMurmur = heartMurmur;
    }

    public String getHeartMurmurDesc() {
        return heartMurmurDesc;
    }

    public void setHeartMurmurDesc(String heartMurmurDesc) {
        this.heartMurmurDesc = heartMurmurDesc;
    }

    public String getAbdominalTenderness() {
        return abdominalTenderness;
    }

    public void setAbdominalTenderness(String abdominalTenderness) {
        this.abdominalTenderness = abdominalTenderness;
    }

    public String getAbdominalTendernessDesc() {
        return abdominalTendernessDesc;
    }

    public void setAbdominalTendernessDesc(String abdominalTendernessDesc) {
        this.abdominalTendernessDesc = abdominalTendernessDesc;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getAbdominaMass() {
        return abdominaMass;
    }

    public void setAbdominaMass(String abdominaMass) {
        this.abdominaMass = abdominaMass;
    }

    public String getAbdominaMassDesc() {
        return abdominaMassDesc;
    }

    public void setAbdominaMassDesc(String abdominaMassDesc) {
        this.abdominaMassDesc = abdominaMassDesc;
    }

    public String getTheAbdomenLiver() {
        return theAbdomenLiver;
    }

    public void setTheAbdomenLiver(String theAbdomenLiver) {
        this.theAbdomenLiver = theAbdomenLiver;
    }

    public String getTheAbdomenLiverDesc() {
        return theAbdomenLiverDesc;
    }

    public void setTheAbdomenLiverDesc(String theAbdomenLiverDesc) {
        this.theAbdomenLiverDesc = theAbdomenLiverDesc;
    }

    public String getSplenomegaly() {
        return splenomegaly;
    }

    public void setSplenomegaly(String splenomegaly) {
        this.splenomegaly = splenomegaly;
    }

    public String getSplenomegalyDesc() {
        return splenomegalyDesc;
    }

    public void setSplenomegalyDesc(String splenomegalyDesc) {
        this.splenomegalyDesc = splenomegalyDesc;
    }

    public String getShiftingDullness() {
        return shiftingDullness;
    }

    public void setShiftingDullness(String shiftingDullness) {
        this.shiftingDullness = shiftingDullness;
    }

    public String getShiftingDullnessDesc() {
        return shiftingDullnessDesc;
    }

    public void setShiftingDullnessDesc(String shiftingDullnessDesc) {
        this.shiftingDullnessDesc = shiftingDullnessDesc;
    }

    public String getLowerExtremityEdema() {
        return lowerExtremityEdema;
    }

    public void setLowerExtremityEdema(String lowerExtremityEdema) {
        this.lowerExtremityEdema = lowerExtremityEdema;
    }

    public String getDorsalisPedisArteryPulse() {
        return dorsalisPedisArteryPulse;
    }

    public void setDorsalisPedisArteryPulse(String dorsalisPedisArteryPulse) {
        this.dorsalisPedisArteryPulse = dorsalisPedisArteryPulse;
    }

    public String getDre() {
        return dre;
    }

    public void setDre(String dre) {
        this.dre = dre;
    }

    public String getDreOther() {
        return dreOther;
    }

    public void setDreOther(String dreOther) {
        this.dreOther = dreOther;
    }

    public String getBreast() {
        return breast;
    }

    public void setBreast(String breast) {
        this.breast = breast;
    }

    public String getBreastOther() {
        return breastOther;
    }

    public void setBreastOther(String breastOther) {
        this.breastOther = breastOther;
    }

    public String getVulva() {
        return vulva;
    }

    public void setVulva(String vulva) {
        this.vulva = vulva;
    }

    public String getVulvaException() {
        return vulvaException;
    }

    public void setVulvaException(String vulvaException) {
        this.vulvaException = vulvaException;
    }

    public String getVaginal() {
        return vaginal;
    }

    public void setVaginal(String vaginal) {
        this.vaginal = vaginal;
    }

    public String getVaginalException() {
        return vaginalException;
    }

    public void setVaginalException(String vaginalException) {
        this.vaginalException = vaginalException;
    }

    public String getCervix() {
        return cervix;
    }

    public void setCervix(String cervix) {
        this.cervix = cervix;
    }

    public String getCervixException() {
        return cervixException;
    }

    public void setCervixException(String cervixException) {
        this.cervixException = cervixException;
    }

    public String getPalace() {
        return palace;
    }

    public void setPalace(String palace) {
        this.palace = palace;
    }

    public String getPalaceException() {
        return palaceException;
    }

    public void setPalaceException(String palaceException) {
        this.palaceException = palaceException;
    }

    public String getUterineAdnexa() {
        return uterineAdnexa;
    }

    public void setUterineAdnexa(String uterineAdnexa) {
        this.uterineAdnexa = uterineAdnexa;
    }

    public String getUterineAdnexaException() {
        return uterineAdnexaException;
    }

    public void setUterineAdnexaException(String uterineAdnexaException) {
        this.uterineAdnexaException = uterineAdnexaException;
    }

    public String getPhysicalOther() {
        return physicalOther;
    }

    public void setPhysicalOther(String physicalOther) {
        this.physicalOther = physicalOther;
    }

    public String getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public String getLeukocyte() {
        return leukocyte;
    }

    public void setLeukocyte(String leukocyte) {
        this.leukocyte = leukocyte;
    }

    public String getPlatelet() {
        return platelet;
    }

    public void setPlatelet(String platelet) {
        this.platelet = platelet;
    }

    public String getOtherBlood() {
        return otherBlood;
    }

    public void setOtherBlood(String otherBlood) {
        this.otherBlood = otherBlood;
    }

    public String getUrineProtein() {
        return urineProtein;
    }

    public void setUrineProtein(String urineProtein) {
        this.urineProtein = urineProtein;
    }

    public String getUrine() {
        return urine;
    }

    public void setUrine(String urine) {
        this.urine = urine;
    }

    public String getKetone() {
        return ketone;
    }

    public void setKetone(String ketone) {
        this.ketone = ketone;
    }

    public String getOccultBloodInUrine() {
        return occultBloodInUrine;
    }

    public void setOccultBloodInUrine(String occultBloodInUrine) {
        this.occultBloodInUrine = occultBloodInUrine;
    }

    public String getOtherUrine() {
        return otherUrine;
    }

    public void setOtherUrine(String otherUrine) {
        this.otherUrine = otherUrine;
    }

    public String getFastingBloodGlucose() {
        return fastingBloodGlucose;
    }

    public void setFastingBloodGlucose(String fastingBloodGlucose) {
        this.fastingBloodGlucose = fastingBloodGlucose;
    }

    public String getRandomBloodGlucose() {
        return randomBloodGlucose;
    }

    public void setRandomBloodGlucose(String randomBloodGlucose) {
        this.randomBloodGlucose = randomBloodGlucose;
    }

    public String getPostprandialBloodGlucose() {
        return postprandialBloodGlucose;
    }

    public void setPostprandialBloodGlucose(String postprandialBloodGlucose) {
        this.postprandialBloodGlucose = postprandialBloodGlucose;
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

    public String getUrinaryAlbumin() {
        return urinaryAlbumin;
    }

    public void setUrinaryAlbumin(String urinaryAlbumin) {
        this.urinaryAlbumin = urinaryAlbumin;
    }

    public String getFecalOccultBlood() {
        return fecalOccultBlood;
    }

    public void setFecalOccultBlood(String fecalOccultBlood) {
        this.fecalOccultBlood = fecalOccultBlood;
    }

    public String getGlycatedHemoglobin() {
        return glycatedHemoglobin;
    }

    public void setGlycatedHemoglobin(String glycatedHemoglobin) {
        this.glycatedHemoglobin = glycatedHemoglobin;
    }

    public String getHepatitisBSurfaceAntigen() {
        return hepatitisBSurfaceAntigen;
    }

    public void setHepatitisBSurfaceAntigen(String hepatitisBSurfaceAntigen) {
        this.hepatitisBSurfaceAntigen = hepatitisBSurfaceAntigen;
    }

    public String getSerumAla() {
        return serumAla;
    }

    public void setSerumAla(String serumAla) {
        this.serumAla = serumAla;
    }

    public String getSerumAa() {
        return serumAa;
    }

    public void setSerumAa(String serumAa) {
        this.serumAa = serumAa;
    }

    public String getAlbumin() {
        return albumin;
    }

    public void setAlbumin(String albumin) {
        this.albumin = albumin;
    }

    public String getTotalBilirubin() {
        return totalBilirubin;
    }

    public void setTotalBilirubin(String totalBilirubin) {
        this.totalBilirubin = totalBilirubin;
    }

    public String getBilirubin() {
        return bilirubin;
    }

    public void setBilirubin(String bilirubin) {
        this.bilirubin = bilirubin;
    }

    public String getSerumCreatinine() {
        return serumCreatinine;
    }

    public void setSerumCreatinine(String serumCreatinine) {
        this.serumCreatinine = serumCreatinine;
    }

    public String getBun() {
        return bun;
    }

    public void setBun(String bun) {
        this.bun = bun;
    }

    public String getPotassiumConcentration() {
        return potassiumConcentration;
    }

    public void setPotassiumConcentration(String potassiumConcentration) {
        this.potassiumConcentration = potassiumConcentration;
    }

    public String getSodiumConcentration() {
        return sodiumConcentration;
    }

    public void setSodiumConcentration(String sodiumConcentration) {
        this.sodiumConcentration = sodiumConcentration;
    }

    public String getTotalCholesterol() {
        return totalCholesterol;
    }

    public void setTotalCholesterol(String totalCholesterol) {
        this.totalCholesterol = totalCholesterol;
    }

    public String getTriglycerides() {
        return triglycerides;
    }

    public void setTriglycerides(String triglycerides) {
        this.triglycerides = triglycerides;
    }

    public String getLdlCholesterol() {
        return ldlCholesterol;
    }

    public void setLdlCholesterol(String ldlCholesterol) {
        this.ldlCholesterol = ldlCholesterol;
    }

    public String getHdlCholesterol() {
        return hdlCholesterol;
    }

    public void setHdlCholesterol(String hdlCholesterol) {
        this.hdlCholesterol = hdlCholesterol;
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

    public String getCervicalSmear() {
        return cervicalSmear;
    }

    public void setCervicalSmear(String cervicalSmear) {
        this.cervicalSmear = cervicalSmear;
    }

    public String getCervicalSmearException() {
        return cervicalSmearException;
    }

    public void setCervicalSmearException(String cervicalSmearException) {
        this.cervicalSmearException = cervicalSmearException;
    }

    public String getOtherLaboratory() {
        return otherLaboratory;
    }

    public void setOtherLaboratory(String otherLaboratory) {
        this.otherLaboratory = otherLaboratory;
    }

    public String getConstitutionType() {
        return constitutionType;
    }

    public void setConstitutionType(String constitutionType) {
        this.constitutionType = constitutionType;
    }

    public String getCerebrovascular() {
        return cerebrovascular;
    }

    public void setCerebrovascular(String cerebrovascular) {
        this.cerebrovascular = cerebrovascular;
    }

    public String getCerebrovascularOther() {
        return cerebrovascularOther;
    }

    public void setCerebrovascularOther(String cerebrovascularOther) {
        this.cerebrovascularOther = cerebrovascularOther;
    }

    public String getKidney() {
        return kidney;
    }

    public void setKidney(String kidney) {
        this.kidney = kidney;
    }

    public String getKidneyOther() {
        return kidneyOther;
    }

    public void setKidneyOther(String kidneyOther) {
        this.kidneyOther = kidneyOther;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public String getHeartOther() {
        return heartOther;
    }

    public void setHeartOther(String heartOther) {
        this.heartOther = heartOther;
    }

    public String getVascular() {
        return vascular;
    }

    public void setVascular(String vascular) {
        this.vascular = vascular;
    }

    public String getVascularOther() {
        return vascularOther;
    }

    public void setVascularOther(String vascularOther) {
        this.vascularOther = vascularOther;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getEyesOther() {
        return eyesOther;
    }

    public void setEyesOther(String eyesOther) {
        this.eyesOther = eyesOther;
    }

    public String getNervoussystems() {
        return nervoussystems;
    }

    public void setNervoussystems(String nervoussystems) {
        this.nervoussystems = nervoussystems;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getPrototypeId() {
        return prototypeId;
    }

    public void setPrototypeId(String prototypeId) {
        this.prototypeId = prototypeId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonNO() {
        return personNO;
    }

    public void setPersonNO(String personNO) {
        this.personNO = personNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getResponsibleDoctorId() {
        return responsibleDoctorId;
    }

    public void setResponsibleDoctorId(String responsibleDoctorId) {
        this.responsibleDoctorId = responsibleDoctorId;
    }

    public String getResponsibleDoctorName() {
        return responsibleDoctorName;
    }

    public void setResponsibleDoctorName(String responsibleDoctorName) {
        this.responsibleDoctorName = responsibleDoctorName;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getSymptomOther() {
        return symptomOther;
    }

    public void setSymptomOther(String symptomOther) {
        this.symptomOther = symptomOther;
    }

    public String getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(String bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public String getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(String pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(String respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public String getLeftDbp() {
        return leftDbp;
    }

    public void setLeftDbp(String leftDbp) {
        this.leftDbp = leftDbp;
    }

    public String getLeftSbp() {
        return leftSbp;
    }

    public void setLeftSbp(String leftSbp) {
        this.leftSbp = leftSbp;
    }

    public String getRightDbp() {
        return rightDbp;
    }

    public void setRightDbp(String rightDbp) {
        this.rightDbp = rightDbp;
    }

    public String getRightSbp() {
        return rightSbp;
    }

    public void setRightSbp(String rightSbp) {
        this.rightSbp = rightSbp;
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

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLifeSkillsScore() {
        return lifeSkillsScore;
    }

    public void setLifeSkillsScore(String lifeSkillsScore) {
        this.lifeSkillsScore = lifeSkillsScore;
    }

    public String getCognitiveFunction() {
        return cognitiveFunction;
    }

    public void setCognitiveFunction(String cognitiveFunction) {
        this.cognitiveFunction = cognitiveFunction;
    }

    public String getCognitiveFunctionScore() {
        return cognitiveFunctionScore;
    }

    public void setCognitiveFunctionScore(String cognitiveFunctionScore) {
        this.cognitiveFunctionScore = cognitiveFunctionScore;
    }

    public String getEmotionalState() {
        return emotionalState;
    }

    public void setEmotionalState(String emotionalState) {
        this.emotionalState = emotionalState;
    }

    public String getEmotionalStateScore() {
        return emotionalStateScore;
    }

    public void setEmotionalStateScore(String emotionalStateScore) {
        this.emotionalStateScore = emotionalStateScore;
    }

    public String getExerciseFrequency() {
        return exerciseFrequency;
    }

    public void setExerciseFrequency(String exerciseFrequency) {
        this.exerciseFrequency = exerciseFrequency;
    }

    public String getEachExerciseTime() {
        return eachExerciseTime;
    }

    public void setEachExerciseTime(String eachExerciseTime) {
        this.eachExerciseTime = eachExerciseTime;
    }

    public String getExerciseTime() {
        return exerciseTime;
    }

    public void setExerciseTime(String exerciseTime) {
        this.exerciseTime = exerciseTime;
    }

    public String getExerciseMethod() {
        return exerciseMethod;
    }

    public void setExerciseMethod(String exerciseMethod) {
        this.exerciseMethod = exerciseMethod;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public boolean smoking() {
        return "4".equals(smokingStatus);
    }



    public boolean noexercise() {
        return "8".equals(exerciseFrequency);
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getSmokingAge() {
        return smokingAge;
    }

    public void setSmokingAge(String smokingAge) {
        this.smokingAge = smokingAge;
    }

    public String getAgeQuit() {
        return ageQuit;
    }

    public void setAgeQuit(String ageQuit) {
        this.ageQuit = ageQuit;
    }

    public String getDrinkingFrequency() {
        return drinkingFrequency;
    }

    public void setDrinkingFrequency(String drinkingFrequency) {
        this.drinkingFrequency = drinkingFrequency;
    }

    public String getDailyAlcoholIntake() {
        return dailyAlcoholIntake;
    }

    public void setDailyAlcoholIntake(String dailyAlcoholIntake) {
        this.dailyAlcoholIntake = dailyAlcoholIntake;
    }

    public String getIsAlcohol() {
        return isAlcohol;
    }

    public void setIsAlcohol(String isAlcohol) {
        this.isAlcohol = isAlcohol;
    }

    public String getAlcoholAge() {
        return alcoholAge;
    }

    public void setAlcoholAge(String alcoholAge) {
        this.alcoholAge = alcoholAge;
    }

    public String getAgeStartedDrinking() {
        return ageStartedDrinking;
    }

    public void setAgeStartedDrinking(String ageStartedDrinking) {
        this.ageStartedDrinking = ageStartedDrinking;
    }

    public String getIsDrunkLastYear() {
        return isDrunkLastYear;
    }

    public void setIsDrunkLastYear(String isDrunkLastYear) {
        this.isDrunkLastYear = isDrunkLastYear;
    }

    public String getAlcoholType() {
        return alcoholType;
    }

    public void setAlcoholType(String alcoholType) {
        this.alcoholType = alcoholType;
    }

    public String getAlcoholTypeOther() {
        return alcoholTypeOther;
    }

    public void setAlcoholTypeOther(String alcoholTypeOther) {
        this.alcoholTypeOther = alcoholTypeOther;
    }

    public String getIsOe() {
        return isOe;
    }

    public void setIsOe(String isOe) {
        this.isOe = isOe;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public String getDustName() {
        return dustName;
    }

    public void setDustName(String dustName) {
        this.dustName = dustName;
    }

    public String getDustProtection() {
        return dustProtection;
    }

    public void setDustProtection(String dustProtection) {
        this.dustProtection = dustProtection;
    }

    public String getDustProtectionDetail() {
        return dustProtectionDetail;
    }

    public void setDustProtectionDetail(String dustProtectionDetail) {
        this.dustProtectionDetail = dustProtectionDetail;
    }

    public String getRadioName() {
        return radioName;
    }

    public void setRadioName(String radioName) {
        this.radioName = radioName;
    }

    public String getRadioProtection() {
        return radioProtection;
    }

    public void setRadioProtection(String radioProtection) {
        this.radioProtection = radioProtection;
    }

    public String getRadioProtectionDetail() {
        return radioProtectionDetail;
    }

    public void setRadioProtectionDetail(String radioProtectionDetail) {
        this.radioProtectionDetail = radioProtectionDetail;
    }

    public String getPhysicsName() {
        return physicsName;
    }

    public void setPhysicsName(String physicsName) {
        this.physicsName = physicsName;
    }

    public String getPhysicsProtection() {
        return physicsProtection;
    }

    public void setPhysicsProtection(String physicsProtection) {
        this.physicsProtection = physicsProtection;
    }

    public String getPhysicsProtectionDetail() {
        return physicsProtectionDetail;
    }

    public void setPhysicsProtectionDetail(String physicsProtectionDetail) {
        this.physicsProtectionDetail = physicsProtectionDetail;
    }

    public String getChemistryName() {
        return chemistryName;
    }

    public void setChemistryName(String chemistryName) {
        this.chemistryName = chemistryName;
    }

    public String getChemistryProtection() {
        return chemistryProtection;
    }

    public void setChemistryProtection(String chemistryProtection) {
        this.chemistryProtection = chemistryProtection;
    }

    public String getChemistryProtectionDetail() {
        return chemistryProtectionDetail;
    }

    public void setChemistryProtectionDetail(String chemistryProtectionDetail) {
        this.chemistryProtectionDetail = chemistryProtectionDetail;
    }

    public String getOtherPoision() {
        return otherPoision;
    }

    public void setOtherPoision(String otherPoision) {
        this.otherPoision = otherPoision;
    }

    public String getOtherPoisionProtection() {
        return otherPoisionProtection;
    }

    public void setOtherPoisionProtection(String otherPoisionProtection) {
        this.otherPoisionProtection = otherPoisionProtection;
    }

    public String getOtherPoisionProtectionDetail() {
        return otherPoisionProtectionDetail;
    }

    public void setOtherPoisionProtectionDetail(String otherPoisionProtectionDetail) {
        this.otherPoisionProtectionDetail = otherPoisionProtectionDetail;
    }

    public String getUltrasonicDesc() {
        return ultrasonicDesc;
    }

    public void setUltrasonicDesc(String ultrasonicDesc) {
        this.ultrasonicDesc = ultrasonicDesc;
    }

    public String getUltrasonicTips() {
        return ultrasonicTips;
    }

    public void setUltrasonicTips(String ultrasonicTips) {
        this.ultrasonicTips = ultrasonicTips;
    }

    public String getLsServiceName() {
        return lsServiceName;
    }

    public void setLsServiceName(String lsServiceName) {
        this.lsServiceName = lsServiceName;
    }

    public String getLsId() {
        return lsId;
    }

    public void setLsId(String lsId) {
        this.lsId = lsId;
    }

    public String getLsServiceId() {
        return lsServiceId;
    }

    public void setLsServiceId(String lsServiceId) {
        this.lsServiceId = lsServiceId;
    }

    public String getLsPrototypeId() {
        return lsPrototypeId;
    }

    public void setLsPrototypeId(String lsPrototypeId) {
        this.lsPrototypeId = lsPrototypeId;
    }

    public String getLsOrgId() {
        return lsOrgId;
    }

    public void setLsOrgId(String lsOrgId) {
        this.lsOrgId = lsOrgId;
    }

    public String getLsPersonId() {
        return lsPersonId;
    }

    public void setLsPersonId(String lsPersonId) {
        this.lsPersonId = lsPersonId;
    }

    public String getLsNumber() {
        return lsNumber;
    }

    public void setLsNumber(String lsNumber) {
        this.lsNumber = lsNumber;
    }

    public String getLsName() {
        return lsName;
    }

    public void setLsName(String lsName) {
        this.lsName = lsName;
    }

    public String getLsMeal() {
        return lsMeal;
    }

    public void setLsMeal(String lsMeal) {
        this.lsMeal = lsMeal;
    }

    public String getLsCleanup() {
        return lsCleanup;
    }

    public void setLsCleanup(String lsCleanup) {
        this.lsCleanup = lsCleanup;
    }

    public String getLsDressup() {
        return lsDressup;
    }

    public void setLsDressup(String lsDressup) {
        this.lsDressup = lsDressup;
    }

    public String getLsToilet() {
        return lsToilet;
    }

    public void setLsToilet(String lsToilet) {
        this.lsToilet = lsToilet;
    }

    public String getLsActivity() {
        return lsActivity;
    }

    public void setLsActivity(String lsActivity) {
        this.lsActivity = lsActivity;
    }

    public String getLsScore() {
        return lsScore;
    }

    public void setLsScore(String lsScore) {
        this.lsScore = lsScore;
    }

    public String getLsFollowupDate() {
        return lsFollowupDate;
    }

    public void setLsFollowupDate(String lsFollowupDate) {
        this.lsFollowupDate = lsFollowupDate;
    }

    public String getLsDoctorId() {
        return lsDoctorId;
    }

    public void setLsDoctorId(String lsDoctorId) {
        this.lsDoctorId = lsDoctorId;
    }

    public String getLsDoctorName() {
        return lsDoctorName;
    }

    public void setLsDoctorName(String lsDoctorName) {
        this.lsDoctorName = lsDoctorName;
    }

    public String getLsRegisterId() {
        return lsRegisterId;
    }

    public void setLsRegisterId(String lsRegisterId) {
        this.lsRegisterId = lsRegisterId;
    }

    public String getLsRegisterDate() {
        return lsRegisterDate;
    }

    public void setLsRegisterDate(String lsRegisterDate) {
        this.lsRegisterDate = lsRegisterDate;
    }

    public String getLsEditDate() {
        return lsEditDate;
    }

    public void setLsEditDate(String lsEditDate) {
        this.lsEditDate = lsEditDate;
    }

    public String getLsVersion() {
        return lsVersion;
    }

    public void setLsVersion(String lsVersion) {
        this.lsVersion = lsVersion;
    }

    public String getLsFlag() {
        return lsFlag;
    }

    public void setLsFlag(String lsFlag) {
        this.lsFlag = lsFlag;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    /**
     * 为了减少终端工作量，对于单选或者多选框，终端传的是数字，中联接收的是文本，需要做个转换
     */


    private String getLifeSkillScoreConvert(String lsScore) {
        try {
            int score = Integer.parseInt(lsScore);
            if (score >= 0 && score <= 3) {
                return "1";
            } else if (score >= 4 && score <= 8) {
                return "2";
            } else if (score >= 9 && score <= 18) {
                return "4";
            } else if (score >= 19) {
                return "8";
            }
        } catch (NumberFormatException e) {

        }
        return "";
    }

}








