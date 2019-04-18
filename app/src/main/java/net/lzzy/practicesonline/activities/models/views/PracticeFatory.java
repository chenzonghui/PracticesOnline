package net.lzzy.practicesonline.activities.models.views;

import net.lzzy.practicesonline.R;
import net.lzzy.practicesonline.activities.constants.DbConstants;
import net.lzzy.practicesonline.activities.utils.AppUtils;
import net.lzzy.sqllib.DbPackager;
import net.lzzy.sqllib.SqlRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 *
 * @author lzzy_gxy
 * @date 2019/4/17
 * Description:
 */
public class PracticeFatory {
    private static final PracticeFatory OUR_INSTANCE = new PracticeFatory();
    private SqlRepository<Practice> repository;

    public static PracticeFatory getInstance() {
        return OUR_INSTANCE;
    }

    private PracticeFatory() {
        repository = new SqlRepository<>(AppUtils.getContext(), Practice.class, DbConstants.packager);
    }

    public List<Practice> get() {
        return repository.get();
    }

    public Practice getById(String id) {
        return repository.getById(id);
    }

    public List<Practice> search(String kw) {
        try {
            return repository.getByKeyword(kw, new String[]{Practice.COL_NANE, Practice.COL_OUTLINES}, false);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public UUID getPracticeId(int apiId) {
        try {
            List<Practice> practices = repository.getByKeyword(String.valueOf(apiId),
                    new String[]{Practice.COL_API_ID}, true);

            if (practices.size() > 0) {
                return practices.get(0).getId();
            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setPracticeDown(String id) {
        Practice practice = getById(id);
        if (practice != null) {
            practice.setDownloadDate(true);
            repository.update(practice);
        }
    }
    public void saveQuestions(List<Question> questions,UUID practiceId){
        for (Question q : questions){
            QuestionFactory.getInstance().insert(q);
        }
        setPracticeDown(practiceId.toString());
    }
    public boolean deletePracticeAndRelated(Practice practice){
           try{
               List<String> sqlActivons =new ArrayList<>();
               sqlActivons.add(repository.getDeleteString(practice));
               QuestionFactory factory =QuestionFactory.getInstance();
               List<Question> questions =factory.getQuestionByPractice(practice.getId().toString());
               if (questions.size()>0){
                   for (Question q : questions){
                       sqlActivons.addAll(factory.getDeleteString(q));
                   }
               }
               repository.exeSqls(sqlActivons);
               if (!isPracticeInDb(practice)){

               }
               return true;
           }catch (Exception e){
               return false;
           }
    }

    public boolean add(Practice practice) {
        if (isPracticeInDb(practice)) {
            return false;
        }
        repository.insert(practice);
        return true;
    }

    private boolean isPracticeInDb(Practice practice) {
        try {
            return repository.getByKeyword(String.valueOf(practice.getApild()),
                    new String[]{Practice.COL_API_ID}, true).size() > 0;
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return true;
        }


    }

//    public List<Practice> searchPractices(String kw) {
//        List<Practice> result =new ArrayList<>();
//        List<Practice> all=getPractice();
//
//        for (Practice practice:all){
//
//            if (practice.toString().contains(kw)){
//                result.add(practice);
//            }
//        }
//
//        return result;
//    }
//     private boolean isPracticelnDb(Practice practice){
//         return searchPractices(practice.toString()).size()>0;
//     }


//     public UUID  getPracticeld(int s){
//       return null;
//     }
//
//     public void saveQuestions(List<Question> UUID){
//
//     }
//     public boolean deletePracticeAndRelated(Practice kw){
//        return false;
//     }
//
//
//}
}
