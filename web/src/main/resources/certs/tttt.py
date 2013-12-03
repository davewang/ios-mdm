import web, os, pprint, json, uuid, sys, re
from plistlib import *
from APNSWrapper import *
from creds import *
from datetime import datetime


wrapper = APNSNotificationWrapper('p12cert.pem', False)
message = APNSNotification() 
message.token(my_DeviceToken)
message.appendProperty(APNSProperty('mdm', my_PushMagic))
wrapper.append(message)
wrapper.notify()
