import java.util.List;
import java.util.regex.Pattern;

public class MorphologicalCondition {
    private String answer;
    private final List<String> list;
    private final Pattern note1=Pattern.compile("4|8|16|24|32");
    private final Pattern note2=Pattern.compile("4分|8分|16分|24分|32分");
    private final Pattern note3=Pattern.compile("階段|配置|処理|乱打|トリル");
    private final Pattern doubling =Pattern.compile("階段|押し");
    private final Pattern key1=Pattern.compile("鍵盤|デバイス|体力|総合力");
    private final Pattern key2=Pattern.compile("難|特化|地帯|寄り|中心|譜面|的|操作");
    private final Pattern difficultyPoint=Pattern.compile("認識|全体|リズム");
    private final Pattern oneHand=Pattern.compile("処理|トリル|階段");
    private final Pattern push=Pattern.compile("同時|刹那|セツナ|到達|BoF|全|交互|無理");
    private final Pattern rightAngle=Pattern.compile("両|連続|同時");
    private final Pattern singleItem=Pattern.compile("ソフラン|鍵盤|乱打|出張|拘束|トリル|複合|複雑|発狂|高密度|直角|曲線|加速|減速|ギアチェン|ラッシュ|個人差|ギミック|低速|地力|物量|裏打ち|連打|往復|変則的|ロング|危険|体力|総合力|大回転|難所|詐称|逆詐称");

    MorphologicalCondition(List<String> li){
        answer="";
        list=li;
    }

    public void ConditionJump(String m){
        if(answer.equals("")&&note1.matcher(m).find()){
            answer+=m;
            return;
        }
        if(note1.matcher(answer).find()&&m.equals("分")){
            answer+=m;
            return;
        }
        if(note2.matcher(answer).find()&&note3.matcher(m).find()){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("符")){
            answer+=m;
            return;
        }
        if(answer.equals("符")&&m.equals("点")){
            answer+=m;
            return;
        }
        if(answer.equals("符点")&&note1.matcher(m).find()){
            answer+=m+"分";
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("二")){
            answer+=m;
            return;
        }
        if(answer.equals("二")&&m.equals("重")){
            answer+=m;
            return;
        }
        if(answer.equals("二重")&&doubling.matcher(m).find()){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("逆")){
            answer+=m;
            return;
        }
        if(answer.equals("逆")&&m.equals("詐称")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("螺旋")){
            answer+=m;
            return;
        }
        if(answer.equals("螺旋")&&m.equals("階段")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }
        
        if(answer.equals("")&&key1.matcher(m).find()){
            answer+=m;
            return;
        }
        if(key2.matcher(answer).find()&&key2.matcher(m).find()){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&difficultyPoint.matcher(m).find()){
            answer+=m;
            return;
        }
        if(difficultyPoint.matcher(answer).find()&&m.equals("難")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("片手")){
            answer+=m;
            return;
        }
        if(answer.equals("片手")&&oneHand.matcher(m).find()){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&push.matcher(m).find()){
            answer+=m;
            return;
        }
        if(push.matcher(answer).find()&&answer.equals("押し")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&rightAngle.matcher(m).find()){
            answer+=m;
            return;
        }
        if(rightAngle.matcher(m).find()&&answer.equals("直角")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("ラス")){
            answer+=m;
            return;
        }
        if(answer.equals("ラス")&&m.equals("殺し")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("エラー")){
            answer+=m;
            return;
        }
        if(answer.equals("エラー")&&m.equals("嵌り")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("混")){
            answer+=m;
            return;
        }
        if(answer.equals("混")&&m.equals("フレ")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("初")){
            answer+=m;
            return;
        }
        if(answer.equals("初")&&m.equals("見殺し")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("ダブル")){
            answer+=m;
            return;
        }
        if(answer.equals("ダブル")&&m.equals("レーザー")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("チップ")){
            answer+=m;
            return;
        }
        if(answer.equals("チップ")&&m.equals("地帯")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("縦")){
            answer+=m;
            return;
        }
        if(answer.equals("縦")&&m.equals("連")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("縦")&&m.equals("連")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("階段")){
            answer+=m;
            return;
        }
        if(answer.equals("階段")&&m.equals("処理")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("激重")){
            answer+=m;
            return;
        }
        if(answer.equals("激重")&&m.equals("ゲージ")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("アナログ")){
            answer+=m;
            return;
        }
        if(answer.equals("アナログ")&&m.equals("デバイス")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("速度")){
            answer+=m;
            return;
        }
        if(answer.equals("速度")&&m.equals("変化")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("繰り返し")){
            answer+=m;
            return;
        }
        if(answer.equals("繰り返し")&&m.equals("配置")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("両")){
            answer+=m;
            return;
        }
        if(answer.equals("両")&&m.equals("デバイス")){
            answer+=m;
            return;
        }
        if(answer.equals("両デバイス")&&m.equals("操作")){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&m.equals("Lv")){
            answer+=m;
            return;
        }

        if(answer.equals("")&&m.equals("局所")){
            answer+=m;
            return;
        }
        if(answer.equals("局所")&&key2.matcher(m).find()){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        if(answer.equals("")&&singleItem.matcher(m).find()){
            answer+=m;
            list.add(answer);
            answer="";
            return;
        }

        answer="";
    }
}
