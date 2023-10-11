package com.eazybytes.eazyschool.audit;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class EazySchoolInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        HashMap<String,String> mapInfo = new HashMap<>();
        mapInfo.put("App Name", "EazySchool");
        mapInfo.put("App Description", "Eazy School Web Application for Students and Admin");
        mapInfo.put("App Version", "1.0.0");
        mapInfo.put("Contact Email", "info@eazyschool.com");
        mapInfo.put("Contact Mobile", "0120-456789");
        builder.withDetail("eazyschool-info", mapInfo);

    }
}
