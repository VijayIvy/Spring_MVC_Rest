package com.cts.nm.util;

import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.cts.nm.model.NmDetails;
import com.cts.nm.model.OnboardDTO;
import com.cts.nm.model.OnboardWrapper;

@Component
public class BlobUtil {
	public void setNmDetails(OnboardDTO l_objOnboard) {
		try {
			NmDetails NmDetailMar = new NmDetails();

			//for (OnboardDTO l_objOnboard : p_objOnboard) {
				NmDetailMar.setNmDetailId(100);
				NmDetailMar.setBuildingAccesRequest(
						l_objOnboard.getBuildingAccesRequest() == null ? null : l_objOnboard.getBuildingAccesRequest());
				NmDetailMar.setMutualCodeOfConduct(l_objOnboard.getMutualCodeOfConduct());
				NmDetailMar.setDrugTestException(l_objOnboard.getDrugTestException());
				NmDetailMar.setPrivacyBasics(l_objOnboard.getPrivacyBasics());
				NmDetailMar.setNewMachineRequest(l_objOnboard.getNewMachineRequest());
				NmDetailMar.setSignOnForm(l_objOnboard.getSignOnForm());
				NmDetailMar.setPpmForm(l_objOnboard.getPpmForm());
				NmDetailMar.setNdaForm(l_objOnboard.getNdaForm());
				NmDetailMar.setNmDrugTestReRaised(l_objOnboard.getNmDrugTestReRaised());
				NmDetailMar.setNmIntroductionTraining(l_objOnboard.getNmIntroductionTraining());
				NmDetailMar.setNmDLUpdate(l_objOnboard.getNmDLUpdate());
				NmDetailMar.setNmDrugTest(l_objOnboard.getNmDrugTest());
				NmDetailMar.setProdTermId(l_objOnboard.getProdTermId());
			//}

			File Marshallerfile = new File("C:/Users/735081/Desktop/NMJML/BlobTestFiles/Source/Blobfile.xml");
			JAXBContext jaxbContextMarshal = JAXBContext.newInstance(NmDetails.class);
			Marshaller jaxbMarshaller = jaxbContextMarshal.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(NmDetailMar, Marshallerfile);
			jaxbMarshaller.marshal(NmDetailMar, System.out);
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}

	}

	public NmDetails getNmDetails(InputStream binaryInput) {
		NmDetails nmDetail = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(NmDetails.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			nmDetail = (NmDetails) jaxbUnmarshaller.unmarshal(binaryInput);

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return nmDetail;
	}
}
