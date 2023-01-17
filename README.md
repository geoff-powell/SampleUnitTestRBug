# Sample Unit Test R bug

* Created this repo to reproduce a bug in Android Gradle task that creates duplicate fields in the R class for Unit Tests. This mainly affects testing frameworks like Robolectric or Paparazzi where it uses the R class within its tests.

### Steps to reproduce tests
1. Run `./gradlew library:generateDebugUnitTestStubRFile` in repo root
2. Navigate to `./library/build/intermediates/compile_and_runtime_not_namespaced_r_class_jar/debugUnitTest/R.jar#com.example.sampleunitTestrbug.R`
3. Inside the `R.stylable` generated class there are duplicated field names under the styleable class (MyButton_android_background)
``` 
public final class R {
   private R() {
   }

   public static final class styleable {
   public static int[] MyButton = new int[]{16842964, 16842964};
   public static int MyButton_android_background;
   public static int MyButton_android_background;
   
       private styleable() {
       }
   }
}
 ```

Alternatively, you can run `./gradlew library:test` and see that the R class fails to load with the duplicate class names.