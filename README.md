SpootITProject - עוזר ראייה חכם
תיאור הפרויקט
SpootITProject הוא פרויקט חדשני לפיתוח אפליקציית Android המיועדת לסייע לאנשים עם לקויות ראייה. האפליקציה משתמשת בטכנולוגיות בינה מלאכותית מתקדמות, במיוחד מודלי זיהוי אובייקטים מבוססי YOLO v3 ו-TensorFlow Lite, כדי לזהות ולתאר אובייקטים בסביבה בזמן אמת באמצעות מצלמת הטלפון.

תכונות עיקריות
זיהוי אובייקטים בזמן אמת: שימוש במודל YOLO v3 לזיהוי מהיר ומדויק של אובייקטים
ממשק משתמש נגיש: עיצוב המותאם לאנשים עם לקויות ראייה
עיבוד מקומי: כל העיבוד מתבצע על המכשיר ללא צורך בחיבור לאינטרנט
ארכיטקטורה מודולרית: מבנה קוד מאורגן עם ספריות נפרדות לפונקציונליות שונות
מבנה הפרויקט
תיקיות ראשיות
SpootITProject/

├── app/                    # האפליקציה הראשית

├── gradle/wrapper/         # קבצי Gradle wrapper

├── lib_interpreter/        # ספרייה לפרשנות מודלי TensorFlow Lite

├── lib_task_api/          # ספרייה ל-API של משימות זיהוי

├── build.gradle           # קובץ build ראשי

├── gradle.properties      # הגדרות Gradle

├── gradlew               # Gradle wrapper (Linux/Mac)

├── gradlew.bat           # Gradle wrapper (Windows)

├── settings.gradle       # הגדרות Gradle

└── .gitignore           # קבצים להתעלמות ב-Git
מבנה תיקיית האפליקציה הראשית (app/)
app/

├── src/

│   ├── main/

│   │   ├── java/com/app/miniproject/iiita/visionassistant/

│   │   │   ├── SplashActivity.java           # מסך פתיחה

│   │   │   ├── WelcomeActivity.java          # מסך ברוכים הבאים

│   │   │   ├── CameraActivity.java           # פעילות מצלמה ראשית

│   │   │   ├── CameraConnectionFragment.java # חיבור למצלמה

│   │   │   ├── LegacyCameraConnectionFragment.java # תמיכה במצלמות ישנות

│   │   │   ├── CaptureActivity.java          # פעילות צילום

│   │   │   ├── DetectorActivity.java         # פעילות זיהוי אובייקטים

│   │   │   ├── OnDeviceActivity.java         # עיבוד על המכשיר

│   │   │   ├── YoloV3Activity.java          # פעילות YOLO v3

│   │   │   ├── customview/                   # תצוגות מותאמות אישית

│   │   │   ├── env/                         # הגדרות סביבה

│   │   │   └── tracking/                    # מעקב אובייקטים

│   │   ├── assets/                          # נכסי האפליקציה

│   │   ├── res/                            # משאבים (layouts, drawables, etc.)

│   │   ├── AndroidManifest.xml             # מניפסט Android

│   │   └── ic_launcher-playstore.png       # אייקון האפליקציה

│   └── androidTest/                        # בדיקות Android

├── build.gradle                           # קובץ build של האפליקציה

├── download_model.gradle                  # קובץ להורדת מודלי AI

├── google-services.json                   # הגדרות Google Services

├── proguard-rules.pro                     # כללי ProGuard לאופטימיזציה

└── local.properties                       # הגדרות מקומיות
ספריות נוספות
lib_interpreter
ספרייה המספקת פונקציונליות בסיסית לטעינה והפעלה של מודלי TensorFlow Lite:

Detector.java - ממשק לזיהוי אובייקטים
TFLiteObjectDetectionAPIModel.java - מודל API לזיהוי אובייקטים
lib_task_api
ספרייה המספקת API ברמה גבוהה יותר לביצוע משימות זיהוי ספציפיות:

Detector.java - ממשק לזיהוי אובייקטים
TFLiteObjectDetectionAPIModel.java - מודל API מתקדם
טכנולוגיות בשימוש
Android SDK: פלטפורמת הפיתוח הראשית
Java: שפת התכנות העיקרית
TensorFlow Lite: מסגרת עבודה לבינה מלאכותית על מכשירים ניידים
YOLO v3 )You Only Look Once): אלגוריתם זיהוי אובייקטים מתקדם
Google Services: שירותי Google לפונקציונליות מורחבת
Gradle: כלי בנייה ואוטומציה



דרישות מערכת
דרישות מינימליות
מערכת הפעלה: Android 5.0 )API level 21) ומעלה
זיכרון RAM: 3GB לפחות (מומלץ 4GB ומעלה)
אחסון פנוי: 500MB לפחות
מצלמה: מצלמה אחורית עם רזולוציה של 8MP לפחות
מעבד: Quad-core 1.5GHz לפחות
הרשאות נדרשות
גישה למצלמה
גישה לאחסון המכשיר
גישה לרשת (לעדכונים)
הוראות התקנה
שלב 1: הכנת סביבת הפיתוח
התקנת Android Studio:

הורד והתקן את Android Studio מהאתר הרשמי
וודא שיש לך את ה-SDK הנדרש (API level 21 ומעלה)

התקנת Java Development Kit ) JDK):

התקן JDK 8 או גרסה חדשה יותר
הגדר את משתנה הסביבה JAVA_HOME
שלב 2: הורדת הפרויקט
# שכפול הפרויקט מ-GitHub

git clone https://github.com/noor-38/SpootITProject.git

# מעבר לתיקיית הפרויקט

cd SpootITProject
שלב 3: הגדרת הפרויקט
פתיחת הפרויקט ב-Android Studio:

פתח את Android Studio
בחר "Open an existing Android Studio project"
נווט לתיקיית הפרויקט ובחר אותה

סנכרון Gradle:

Android Studio יבצע סנכרון אוטומטי של Gradle
אם לא, לחץ על "Sync Now" בהודעה שתופיע

הורדת מודלי AI:

הפרויקט כולל קובץ download_model.gradle להורדת מודלים
הרץ את המשימה: ./gradlew downloadModel
שלב 4: הגדרת Google Services (אופציונלי)
אם אתה רוצה להשתמש בשירותי Google:

צור פרויקט חדש ב-Google Cloud Console
הפעל את ה-APIs הנדרשים
הורד את קובץ google-services.json
החלף את הקובץ הקיים בתיקיית app/












הוראות הפעלה
הפעלה במצב פיתוח
חיבור מכשיר או אמולטור:

חבר מכשיר Android עם מצב פיתוח מופעל
או הפעל אמולטור Android

בנייה והפעלה:

# בנייה של הפרויקט

./gradlew build

# התקנה על המכשיר

./gradlew installDebug

הפעלה מ-Android Studio:

לחץ על כפתור "Run" 
בחר את המכשיר המטרה
האפליקציה תותקן ותופעל אוטומטית
בנייה לייצור
# בנייה של גרסת release

./gradlew assembleRelease

# הקובץ APK יימצא ב:

# app/build/outputs/apk/release/app-release.apk
שימוש באפליקציה
הפעלה ראשונה
מסך פתיחה: האפליקציה תתחיל במסך הפתיחה (Splash Screen)
מסך ברוכים הבאים: יוצג מסך הסבר על האפליקציה
הרשאות: האפליקציה תבקש הרשאות למצלמה ואחסון
תכונות עיקריות
זיהוי אובייקטים: הפעל את המצלמה וכוון לאובייקטים לזיהוי
מצבי תצוגה שונים: בחר בין מצבי תצוגה שונים לפי הצרכים
הגדרות נגישות: התאם את ההגדרות לצרכים האישיים
פתרון בעיות נפוצות
בעיות בנייה
שגיאה: "SDK not found"

# הגדר את נתיב ה-SDK בקובץ local.properties

echo "sdk.dir=/path/to/your/android/sdk" > local.properties

שגיאה: "Gradle sync failed"

וודא שיש לך חיבור לאינטרנט
נסה לנקות ולבנות מחדש: ./gradlew clean build
בעיות הפעלה
האפליקציה קורסת בעת הפעלת המצלמה

וודא שניתנו הרשאות מצלמה
בדוק שהמכשיר תומך במצלמה

זיהוי אובייקטים לא עובד

וודא שמודלי ה-AI הורדו בהצלחה
בדוק שיש מספיק זיכרון פנוי במכשיר
תרומה לפרויקט
אנו מזמינים מפתחים לתרום לפרויקט:

Fork את הפרויקט
צור branch חדש לתכונה שלך
Commit את השינויים
Push ל-branch
פתח Pull Request
הנחיות תרומה
עקוב אחר סגנון הקוד הקיים
הוסף בדיקות לתכונות חדשות
עדכן את התיעוד בהתאם
וודא שהקוד עובר את כל הבדיקות



הערה: פרויקט זה פותח למטרות חינוכיות ומחקריות. השימוש בו הוא על אחריות המשתמש בלבד.

