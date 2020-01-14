
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
	
	public static void main(String[] args) {
		
	}

	public static float input(String drug1,String drug2,String drug3,String drug4,String drug5,float ml1,float ml2,float ml3,float ml4,float ml5) throws Exception{
		// TODO Auto-generated method stub
		
		//動態配置檔案位置
	        String path = System.getProperty("mydir");
	        if(path == null){
	            System.setProperty("mydir", System.getProperty("user.dir"));
	        }
	
	        
		String  pathxml=System.getProperty("mydir")+"\\DrugModel4.pmml";	//pmml模型檔位置
		
		//設定input
		//Map<String, Double>  mapD=new HashMap<String, Double>();
		Map<String, Float>  mapF=new HashMap<String, Float>(1000);
		
		//輸入值初始化
		mapF.put("ACEI", (float) 0);
		mapF.put("ARB", (float) 0);
		mapF.put("Statins", (float) 0);
		mapF.put("CCB", (float) 0);
		mapF.put("INH", (float) 0);
		mapF.put("RMP", (float) 0);
		mapF.put("PZA", (float) 0);
		mapF.put("EMB", (float) 0);
		mapF.put("Gliben", (float) 0);
		mapF.put("Metformin", (float) 0);
		mapF.put("Actos", (float) 0);
		mapF.put("Januvia", (float) 0);
		mapF.put("Lasix", (float) 0);
		mapF.put("Aldactone", (float) 0);
		mapF.put("Fluitran", (float) 0);
		mapF.put("Tenormin", (float) 0);
		mapF.put("Forteo", (float) 0);
		mapF.put("VitD", (float) 0);
		mapF.put("Fosrenol", (float) 0);
		mapF.put("Cinacalcet", (float) 0);
		mapF.put("Relifex", (float) 0);
		mapF.put("Aralan", (float) 0);
		mapF.put("Cuprimine", (float) 0);
		mapF.put("Cytoxan", (float) 0);
		mapF.put("Steroid", (float) 0);
		mapF.put("Acyclovir", (float) 0);
		mapF.put("Famciovir", (float) 0);
		mapF.put("NSAID", (float) 0);
		mapF.put("Zostavax", (float) 0);
		mapF.put("Aspirin", (float) 0);
		mapF.put("Pantoloc", (float) 0);
		mapF.put("Cytotec", (float) 0);
		mapF.put("Zantac", (float) 0);
		mapF.put("Bosentan", (float) 0);
		mapF.put("Riociguat", (float) 0);
		mapF.put("Tadalafil", (float) 0);
		mapF.put("Iloprost", (float) 0);
		mapF.put("Sildenafil", (float) 0);
		mapF.put("Biperiden", (float) 0);
		mapF.put("Selegiline", (float) 0);
		mapF.put("Entacapone", (float) 0);
		mapF.put("Pramipexole", (float) 0);
		mapF.put("Oxytocin", (float) 0);
		mapF.put("Ergots", (float) 0);
		mapF.put("Ergonovine", (float) 0);
		mapF.put("Carboprost", (float) 0);
		mapF.put("Ketoprofen", (float) 0);
		mapF.put("Diclofenac", (float) 0);
		mapF.put("Piroxicam", (float) 0);
		mapF.put("Ceftibuten", (float) 0);
		mapF.put("Cefuroxime", (float) 0);
		mapF.put("Imipenem", (float) 0);
		mapF.put("Meropenem", (float) 0);
		mapF.put("Dulcolax", (float) 0);
		mapF.put("AFGF", (float) 0);
		mapF.put("Lidocaine", (float) 0);
		mapF.put("Adriamycin", (float) 0);
		mapF.put("Cisplatinum", (float) 0);
		mapF.put("Bleomycin", (float) 0);
		mapF.put("Amantadine", (float) 0);
		mapF.put("MTX", (float) 0);
		mapF.put("Tolcapone", (float) 0);
		mapF.put("Levodopa", (float) 0);
		mapF.put("NAC", (float) 0);
		mapF.put("Silymarin", (float) 0);
		mapF.put("VitC", (float) 0);
		mapF.put("Biaxin", (float) 0);
		mapF.put("Zeto", (float) 0);
		mapF.put("Antibiotic", (float) 0);
		mapF.put("Tincture", (float) 0);
		mapF.put("Cytotoxic", (float) 0);
		mapF.put("Heparin", (float) 0);
		mapF.put("Androcur", (float) 0);
		mapF.put("Premarin", (float) 0);
		mapF.put("Progynova", (float) 0);
		mapF.put("Ritalin", (float) 0);
		mapF.put("Strattera", (float) 0);
		mapF.put("Triptan", (float) 0);
		mapF.put("Ergotamine", (float) 0);
		mapF.put("Morphine", (float) 0);
		mapF.put("Depakine", (float) 0);
		mapF.put("Keppra", (float) 0);
		mapF.put("Clobazam", (float) 0);
		mapF.put("Dormicum", (float) 0);
		mapF.put("Dicuclomine", (float) 0);
		mapF.put("TIG", (float) 0);
		mapF.put("Penicillin", (float) 0);
		mapF.put("Baclofen", (float) 0);
		mapF.put("Cataflam", (float) 0);
		mapF.put("Tacrine", (float) 0);
		mapF.put("Donepezil", (float) 0);
		mapF.put("Rivastigmine", (float) 0);
		mapF.put("Galantamine", (float) 0);
		mapF.put("Indomethacin", (float) 0);
		mapF.put("ATCH", (float) 0);
		mapF.put("LAMA", (float) 0);
		mapF.put("LABA", (float) 0);
		mapF.put("Mexiletine", (float) 0);
		mapF.put("Amiodarone", (float) 0);
		mapF.put("Sotalol", (float) 0);
		mapF.put("Propranol", (float) 0);
		mapF.put("Zolpidem", (float) 0);
		mapF.put("Biogen", (float) 0);
		mapF.put("Dicyclomine", (float) 0);
		mapF.put("Codeine", (float) 0);
		mapF.put("Sumatriptan", (float) 0);
		mapF.put("Calciton", (float) 0);
		mapF.put("Alprazolam", (float) 0);
		mapF.put("RFT", (float) 0);
		mapF.put("Erythrocin", (float) 0);
		mapF.put("Colchicin", (float) 0);
		mapF.put("Amoxicilla", (float) 0);
		mapF.put("Concerta", (float) 0);
		mapF.put("Cisplatinum", (float) 0);
		mapF.put("Safetypercent", (float) 0);
		
		//接收值導入
		mapF.put(drug1, (float) ml1);
		mapF.put(drug2, (float) ml2);
		mapF.put(drug3, (float) ml3);
		mapF.put(drug4, (float) ml4);
		mapF.put(drug5, (float) ml5);
		
		float resultvalue = predict(mapF,pathxml);	//導入模型訓練
		return resultvalue;	//回傳預測值
	}
	
	public static float predict(Map<String, Float> DRUGmap,String  pathxml)throws Exception {
		//模型導入
		PMML pmml;		
		File file = new File(pathxml);
		float primitiveValue = -1;	//result值
		
		InputStream inputStream = new FileInputStream(file);
		try (InputStream is = inputStream) {
			pmml = org.jpmml.model.PMMLUtil.unmarshal(is);
			ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();
			ModelEvaluator<?> modelEvaluator = modelEvaluatorFactory.newModelEvaluator(pmml);
			Evaluator evaluator = (Evaluator) modelEvaluator;
			List<InputField> inputFields = evaluator.getInputFields();		//從map中抓數據
			
			Map<FieldName, FieldValue> arguments = new LinkedHashMap<>();
			
			for (InputField inputField : inputFields) {
				FieldName inputFieldName = inputField.getName();
				
				//Object SAFETYrawValue = SAFETYmap.get(inputFieldName.getValue());	//抓安全率資料
				Object DRUGrawValue = DRUGmap.get(inputFieldName.getValue());	//抓藥物資料
				
				//FieldValue SAFETYinputFieldValue = inputField.prepare(SAFETYrawValue);
				FieldValue DRUGinputFieldValue = inputField.prepare(DRUGrawValue);
				System.out.println(inputFieldName);
				System.out.println(DRUGinputFieldValue);
				arguments.put(inputFieldName, DRUGinputFieldValue);
				}
			
			Map<FieldName, ?> results = evaluator.evaluate(arguments);
			List<TargetField> targetFields = evaluator.getTargetFields();
			
			//輸出
			for (TargetField targetField : targetFields) {
				FieldName targetFieldName = targetField.getName();
				Object targetFieldValue = results.get(targetFieldName);
				System.err.println("target: " + targetFieldName.getValue()+ " value: " + targetFieldValue);
				if (targetFieldValue instanceof Computable) {
		            Computable computable = (Computable) targetFieldValue;
		            primitiveValue = (float)computable.getResult();
		        }
				System.out.print(primitiveValue);
			}
			
		}
		return primitiveValue;
	}
	
	
	
	
}
