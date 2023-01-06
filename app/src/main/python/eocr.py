import easyocr
import numpy as np
import cv2

def main(uri):
    img = str(uri)
    resulttxtarr = []
    reader = easyocr.Reader(['en'])
    results = reader.readtext(img)
    imgRead = cv2.imread(img)
    shapes = np.zeros_like(imgRead, np.uint8)
    overlay = imgRead.copy()  
    overlay, resulttxtarr = highlight("input_string", results, shapes, imgRead, resulttxtarr)
    cv2.imwrite("/output/path.jpg", overlay)
    res = " ".join(resulttxtarr)
    print(res)
    return res

def highlight(text, results, shapes, imgRead, resulttxtarr):
    for result in results:
        tl = (int(result[0][0][0]), int(result[0][0][1]))
        br = (int(result[0][2][0]), int(result[0][2][1]))
        txt = result[1]
        resulttxtarr.append(txt)
        rect = cv2.rectangle(shapes, tl, br, (0, 215, 255), 0)
        if txt == text:
            rect = cv2.rectangle(shapes, tl, br, (0, 215, 255), cv2.FILLED)
        overlay = cv2.addWeighted(imgRead, 0.5, rect, 0.5, 1.0)
    return overlay, resulttxtarr
