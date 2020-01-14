import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

public class predict_model {

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
