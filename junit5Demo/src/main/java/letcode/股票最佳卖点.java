package letcode;

/**
 * @ProjectName: seleniumCoding
 * @Package: letcode
 * @ClassName: 股票最佳卖点
 * @Author: 还是那个橙子
 * @Description:
 * @Date: 2022/11/11 17:16
 * @Version: 1.0
 *  * 股票上涨的最大值和股票开始上涨的最小值，计算他们的差就是这段时间内股票的最大利润。
 *  * 如果股票下跌就不用计算，最终只需要把所有股票上涨的时间段内的利润累加就是我们所要求的结果
 */

public class 股票最佳卖点 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) { // 股票价格小于2个，不能买卖
            return 0;
        }
        int total = 0; // 初始化总利润
        for (int i = 0; i < prices.length - 1; i++) {  //  遍历股票价格
            //原数组中如果后一个减去前一个是正数，说明是上涨的，
            //前一天大于后一天，说明是上涨的
            if (prices[i + 1] - prices[i] > 0) {
                total= total+(prices[i + 1] - prices[i]);
            }
        }
        return total;
    }
}

