/**
 * Rss reader的功能实现部分。采用单例模式。
 *
 * @author paulzhn
 * @since 2019/11/16
 */
public class RssAnalyser {
    private static final RssAnalyser ANALYSER = new RssAnalyser();
    private RssAnalyser() {}
    public static RssAnalyser getInstance() {
        return ANALYSER;
    }
    

}
