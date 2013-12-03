package com.sinonet.mdm.payloads;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 下午1:11
 * To change this template use File | Settings | File Templates.
 */
public class SettingsCommand extends Command {
    private List<NSDictionary> settings = new ArrayList<NSDictionary>();
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_SETTINGS );
    }
    @Override
    public void doExecute() {
        if (settings.size()>0)
        {
            NSArray array = new NSArray(settings.size());
            for (int i=0; i<settings.size(); i++)
            {
                array.setValue(i, settings.get(i));
            }
            getCommand().put("Settings",array);
        }
    }
    public void addSetting(NSDictionary setting)
    {
        settings.add(setting);
    }
    public void removeSetting(NSDictionary setting)
    {
        settings.remove(setting);
    }
    public void clearSettings()
    {
        settings.clear();
    }
    public void isEnabledVoiceRoaming(Boolean enable)
    {
        NSDictionary dictionary = new NSDictionary();
        dictionary.put("Item","VoiceRoaming");
        dictionary.put("Enabled",enable);
        addSetting(dictionary);
    }
    public void isEnabledPersonalHotspot(Boolean enable)
    {
        NSDictionary dictionary = new NSDictionary();
        dictionary.put("Item","PersonalHotspot");
        dictionary.put("Enabled",enable);
        addSetting(dictionary);
    }
    public void isEnabledDataRoaming(Boolean enable)
    {
        NSDictionary dictionary = new NSDictionary();
        dictionary.put("Item","DataRoaming");
        dictionary.put("Enabled",enable);
        addSetting(dictionary);
    }
    public void setsOrUpdatesApplicationAttributes(String identifier,NSDictionary attributes)
    {
        NSDictionary dictionary = new NSDictionary();
        dictionary.put("Item","ApplicationAttributes");
        dictionary.put("Identifier",identifier);
        dictionary.put("Attributes",attributes);
        addSetting(dictionary);
    }

    public void setsOrUpdatesApplicationConfiguration(String identifier,NSDictionary configuration)
    {
        NSDictionary dictionary = new NSDictionary();
        dictionary.put("Item","ApplicationConfiguration");
        dictionary.put("Identifier",identifier);
        dictionary.put("Configuration",configuration);
        addSetting(dictionary);
    }

    public void setsDeviceLanguage(String language)
    {
        NSDictionary dictionary = new NSDictionary();
        dictionary.put("Item","Language");
        dictionary.put("Language",language);
        addSetting(dictionary);
    }

    /**
     * To send an Locale command (available only on supervised Apple TV devices running iOS 7—Apple TV software 6.0—and later),
     * @param locale
     */
    public void setsDeviceLocale(String locale)
    {
        NSDictionary dictionary = new NSDictionary();
        dictionary.put("Item","Locale");
        dictionary.put("Language",locale);
        addSetting(dictionary);
    }
    /**
     * In iOS 7 and later, to send an OrganizationInfo command, the server sends a dictionary containing the following keys:
     * @param organizationName
     * @param organizationAddress options
     */
    public void setsInformationAboutOrganization(String organizationName,String organizationAddress,String organizationPhone,String organizationEmail,String organizationMagic)
    {
        NSDictionary dictionary = new NSDictionary();
        dictionary.put("Item","OrganizationInfo");
        if (organizationName != null ||organizationAddress != null||organizationPhone != null||organizationEmail != null ||organizationMagic!=null)
        {
            NSDictionary organizationInfo = new NSDictionary();
            if (organizationName!=null)
                organizationInfo.put("OrganizationName",organizationName);
            if (organizationAddress!=null)
                organizationInfo.put("OrganizationAddress",organizationAddress);
            if (organizationPhone!=null)
                organizationInfo.put("OrganizationPhone",organizationPhone);
            if (organizationEmail!=null)
                organizationInfo.put("OrganizationEmail",organizationEmail);
            if (organizationMagic!=null)
                organizationInfo.put("OrganizationMagic",organizationMagic);
        }

        addSetting(dictionary);
    }

    /**
     *
     * @param options
     */
    public void SetsMDMOptions(NSDictionary options)
    {
        NSDictionary dictionary = new NSDictionary();
        dictionary.put("Item","MDMOptions");
        dictionary.put("MDMOptions",options);
        addSetting(dictionary);
    }


}
