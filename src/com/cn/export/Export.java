package com.cn.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Export {
	public void exportTxt() {
		// CobraCst.TYPE = "cobra", 路径文件夹名
		final FieldWriter writer = new FieldWriter("CobraCst.TYPE", new HashMap<String, Comparable>());
		final FileOutputStream path = new FileOutputStream(new File("XXX"));
		final PrintStream printPath = new PrintStream(path);

		final Map<String, Comparable> fieldMap = new HashMap<String, Comparable>();
		// 遍历集合forecasts
		for (PrevisionJour pvc : forecasts) {
			fieldMap.clear();
			fieldMap.put(CobraCst.ID_String, CobraCst.ID);
			fieldMap.put(CobraCst.DATE_EXTRACTION_DATE, extraction);
			fieldMap.put(CobraCst.CENTRE_STRING, cutId);
			fieldMap.put(CobraCst.FIRST_DATE_INTERVAL_EXTRACTION_DATE,
					this.trtEnvoiCobra.calculateFirstDateExtraction(this.broker));
			fieldMap.put(CobraCst.FIN_PLAGE_EXTRACTION_DATE,
					this.trtEnvoiCobra.calculateLastDateExtraction(this.broker));
			fieldMap.put(CobraCst.PRODUCT_STRING, pvc.getFluxLog().getProduit());
			fieldMap.put(CobraCst.COFOR_STRING, pvc.getFluxLog().getFrnParCof());
			fieldMap.put(CobraCst.DHRI_DATE, pvc.getDhric());
			fieldMap.put(CobraCst.DHRP_DATE, pvc.getDhrp());
			fieldMap.put(CobraCst.DHEF_DATE, pvc.getDhef());
			fieldMap.put(CobraCst.QUANTITE_LONG, StringUtils.leftPad(String.valueOf(pvc.getQuantite()), 9, '0'));
			fieldMap.put(CobraCst.QTE_GLOBALE_STRING, "Y");
			// MVU : PFA doesn't know. Can be null, so leave as be
			fieldMap.put(CobraCst.CODE_LIVRAISON_STRING, null);
			final FluxLogistiqueBean fluxLogistique = this.referentiel.getFluxLog(pvc.getFluxLog().getIdPk());
			if (null == fluxLogistique) {
				fieldMap.put(CobraCst.UA_LONG, null);
				this.trtEnvoiCobra.fillIndiceDhef(fluxLogistique, fieldMap);
				fieldMap.put(CobraCst.RESSAP_STRING, null);
			} else {
				fieldMap.put(CobraCst.UA_LONG,
						StringUtils.leftPad(String.valueOf(fluxLogistique.getEtalonnageUaAval()), 9, '0'));
				final FluxNomenclatureBean fluxNomenclature = this.referentiel
						.getFluxNomenc(fluxLogistique.getIdFluxNomencFk());
				this.trtEnvoiCobra.fillIndiceDhef(fluxLogistique, fieldMap);
				fieldMap.put(CobraCst.RESSAP_STRING, fluxNomenclature.getRessap());
			}
			fieldMap.put(CobraCst.SGR_STRING, pvc.getFluxLog().getSgrCli());
			fieldMap.put(CobraCst.FILLER, null);
			// 第三个参数，properties里面 "_" 后面的名字
			writer.writeLine(printPath, fieldMap, "PEGB");
		}
	}
}
