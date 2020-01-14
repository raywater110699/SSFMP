
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.Computable;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.InputField;
import org.jpmml.evaluator.ModelEvaluator;
import org.jpmml.evaluator.ModelEvaluatorFactory;
import org.jpmml.evaluator.TargetField;

public class ModelLoading {
	
	public static float input(information IF) throws Exception{
		// TODO Auto-generated method stub
		
		float zero=0;
		
		//動態配置檔案位置
	        String path = System.getProperty("mydir");
	        if(path == null){
	            System.setProperty("mydir", System.getProperty("user.dir"));
	        }
	
	        
		String  pathxml = System.getProperty("mydir")+"\\DrugModel4.pmml";	//pmml模型檔位置
		
		//設定input
		Map<String, Float>  mapF = new HashMap<String, Float>(30);
		
		//輸入值初始化
		mapF.put("ACEI", zero);	
		mapF.put("ARB", zero);
		mapF.put("Statins", zero);
		mapF.put("CCB", zero);
		mapF.put("INH", zero);
		mapF.put("RMP", zero);
		mapF.put("PZA", zero);
		mapF.put("EMB", zero);
		mapF.put("Gliben", zero);
		mapF.put("Metformin", zero);
		mapF.put("Actos", zero);
		mapF.put("Januvia", zero);
		mapF.put("Lasix", zero);
		mapF.put("Aldactone", zero);
		mapF.put("Fluitran", zero);
		mapF.put("Tenormin", zero);
		mapF.put("Forteo", zero);
		mapF.put("VitD", zero);
		mapF.put("Fosrenol", zero);
		mapF.put("Cinacalcet", zero);
		mapF.put("Relifex", zero);
		mapF.put("Aralan", zero);
		mapF.put("Cuprimine", zero);
		mapF.put("Cytoxan", zero);
		mapF.put("Steroid", zero);
		mapF.put("Acyclovir", zero);
		mapF.put("Famciovir", zero);
		mapF.put("NSAID", zero);
		mapF.put("Zostavax", zero);
		mapF.put("Aspirin", zero);
		mapF.put("Pantoloc", zero);
		mapF.put("Cytotec", zero);
		mapF.put("Zantac", zero);
		mapF.put("Bosentan", zero);
		mapF.put("Riociguat", zero);
		mapF.put("Tadalafil", zero);
		mapF.put("Iloprost", zero);
		mapF.put("Sildenafil", zero);
		mapF.put("Biperiden", zero);
		mapF.put("Selegiline", zero);
		mapF.put("Entacapone", zero);
		mapF.put("Pramipexole", zero);
		mapF.put("Oxytocin", zero);
		mapF.put("Ergots", zero);
		mapF.put("Ergonovine", zero);
		mapF.put("Carboprost", zero);
		mapF.put("Ketoprofen", zero);
		mapF.put("Diclofenac", zero);
		mapF.put("Piroxicam", zero);
		mapF.put("Ceftibuten", zero);
		mapF.put("Cefuroxime", zero);
		mapF.put("Imipenem", zero);
		mapF.put("Meropenem", zero);
		mapF.put("Dulcolax", zero);
		mapF.put("AFGF", zero);
		mapF.put("Lidocaine", zero);
		mapF.put("Adriamycin", zero);
		mapF.put("Cisplatinum", zero);
		mapF.put("Bleomycin", zero);
		mapF.put("Amantadine", zero);
		mapF.put("MTX", zero);
		mapF.put("Tolcapone", zero);
		mapF.put("Levodopa", zero);
		mapF.put("NAC", zero);
		mapF.put("Silymarin", zero);
		mapF.put("VitC", zero);
		mapF.put("Biaxin", zero);
		mapF.put("Zeto", zero);
		mapF.put("Antibiotic", zero);
		mapF.put("Tincture", zero);
		mapF.put("Cytotoxic", zero);
		mapF.put("Heparin", zero);
		mapF.put("Androcur", zero);
		mapF.put("Premarin", zero);
		mapF.put("Progynova", zero);
		mapF.put("Ritalin", zero);
		mapF.put("Strattera", zero);
		mapF.put("Triptan", zero);
		mapF.put("Ergotamine", zero);
		mapF.put("Morphine", zero);
		mapF.put("Depakine", zero);
		mapF.put("Keppra", zero);
		mapF.put("Clobazam", zero);
		mapF.put("Dormicum", zero);
		mapF.put("Dicuclomine", zero);
		mapF.put("TIG", zero);
		mapF.put("Penicillin", zero);
		mapF.put("Baclofen", zero);
		mapF.put("Cataflam", zero);
		mapF.put("Tacrine", zero);
		mapF.put("Donepezil", zero);
		mapF.put("Rivastigmine", zero);
		mapF.put("Galantamine", zero);
		mapF.put("Indomethacin", zero);
		mapF.put("ATCH", zero);
		mapF.put("LAMA", zero);
		mapF.put("LABA", zero);
		mapF.put("Mexiletine", zero);
		mapF.put("Amiodarone", zero);
		mapF.put("Sotalol", zero);
		mapF.put("Propranol", zero);
		mapF.put("Zolpidem", zero);
		mapF.put("Biogen", zero);
		mapF.put("Dicyclomine", zero);
		mapF.put("Codeine", zero);
		mapF.put("Sumatriptan", zero);
		mapF.put("Calciton", zero);
		mapF.put("Alprazolam", zero);
		mapF.put("RFT", zero);
		mapF.put("Erythrocin", zero);
		mapF.put("Colchicin", zero);
		mapF.put("Amoxicilla", zero);
		mapF.put("Concerta", zero);
		mapF.put("Cisplatinum", zero);
		mapF.put("Safetypercent", zero);
		
		//接收值導入
		mapF.put(IF.D1, IF.M1);
		mapF.put(IF.D2, IF.M2);
		mapF.put(IF.D3, IF.M3);
		mapF.put(IF.D4, IF.M4);
		mapF.put(IF.D5, IF.M5);
		
		float resultvalue = predict_model.predict(mapF,pathxml);	//導入模型訓練
		return resultvalue;	//回傳預測值
	}
	
}
