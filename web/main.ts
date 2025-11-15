const processedFrame = document.getElementById('processed-frame') as HTMLImageElement;
const stats = document.getElementById('stats');

// This is a dummy base64 encoded image. In a real application, you would get this from your Android app.
const dummyBase64Image = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=';

processedFrame.src = dummyBase64Image;

const frameStats = {
    fps: 15,
    resolution: '640x480'
};

if (stats) {
    stats.innerText = `FPS: ${frameStats.fps} | Resolution: ${frameStats.resolution}`;
}
