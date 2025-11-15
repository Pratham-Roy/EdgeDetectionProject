package com.example.project1

import androidx.camera.core.ImageProxy
import org.opencv.core.CvType
import org.opencv.core.Mat

fun ImageProxy.toMat(): Mat {
    val planes = this.planes
    val yBuffer = planes[0].buffer
    val uBuffer = planes[1].buffer
    val vBuffer = planes[2].buffer

    val ySize = yBuffer.remaining()
    val uSize = uBuffer.remaining()
    val vSize = vBuffer.remaining()

    val nv21 = ByteArray(ySize + uSize + vSize)

    yBuffer.get(nv21, 0, ySize)
    vBuffer.get(nv21, ySize, vSize)
    uBuffer.get(nv21, ySize + vSize, uSize)

    val yuv = Mat(this.height + this.height / 2, this.width, CvType.CV_8UC1)
    yuv.put(0, 0, nv21)
    val mat = Mat()
    org.opencv.imgproc.Imgproc.cvtColor(yuv, mat, org.opencv.imgproc.Imgproc.COLOR_YUV2BGRA_NV21, 4)
    yuv.release()
    return mat
}
