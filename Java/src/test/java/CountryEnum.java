import lombok.Getter;

public enum CountryEnum
{
    ONE(1,"魏国"),TWO(2,"韩国"),THREE(3,"燕国"),FOUR(4,"赵国"),

    FIVE(5,"楚国"),SIX(6,"齐国");


    @Getter public Integer retCode;
    @Getter public String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index)
    {
        // 得到枚举类所有参数的数组
        CountryEnum[] myArray = CountryEnum.values();
        // 循环遍历所有枚举值
        for (CountryEnum countryEnum : myArray) {
            // 判断：如果索引值index等于枚举类中的KEY值
            if (index == countryEnum.getRetCode())
            {
                // 则返回该枚举值
                return countryEnum;
            }
        }
        // 如果没有遍历到，则返回null。
        return null;
    }
}
