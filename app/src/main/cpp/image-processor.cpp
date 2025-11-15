#include <jni.h>
#include <opencv2/core.hpp>
#include <opencv2/imgproc.hpp>

extern "C" JNIEXPORT void JNICALL
Java_com_example_project1_MainActivity_processImage(
        JNIEnv *env,
        jobject /* this */,
        jlong input_address,
        jlong output_address) {
    // Cast the input and output addresses to cv::Mat pointers
    cv::Mat &input = *(cv::Mat *) input_address;
    cv::Mat &output = *(cv::Mat *) output_address;

    // Apply Canny Edge Detection
    cv::Canny(input, output, 100, 200);
}
