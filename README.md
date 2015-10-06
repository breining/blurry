# blurry
Your program is to read the image data from an external file, perform some sequence of manipu-
lations on the image, and write the resulting image to an external file. The input and output file
names are to be taken from the command line. See the posted File i/o example for an idea of how
to do this.
You will continue to use the two image arrays in your ImageManip class. After each operation
listed below you will copy the resulting manipulated array back into the original array so that
additional operations may be performed on it.

Manipulations
Here are the additional methods to implement in your ImageManip class. Each of these methods
will put its result in the
1. blurImage - Takes an integer parameter specifying the radius of the blur, that is, the number
of pixels in every direction, to include in the calculated average and generates a new blurred
image.
2. darkenImage - Takes an integer parameter and generates a new image with each value reduced
by the amount specied by the parameter.
3. lightenImage - Takes an integer parameter and generates a new image with each value in-
creased by the amount specied by the parameter.
4. invertImage - Takes no parameters and generates a new image in which the pixels are all
subtracted from 255. For example, if the value of a pixel is 189, its new value will be 255 -
189 = 66.
5. flipImage - Takes no parameters and generates a new image 
ipped horizontally.
6. thresholdImage - Takes an integer parameter and generates a new image in which every pixel
above the parameter value is set to 255 and every pixel below the parameter value is set to 0. 
You can choose either option if the pixel happens to equal the parameter.
7. rotateImage (extra credit) - Takes no parameters and generates a new image rotated 90 degrees
counter-clockwise. Note: This new image will have the height and width swapped. In other
words you will need to create a new array with the dimensions swapped.

Testing
You will need to develop various instances of test data for your program. I suggest that you start
with small arrays to verify that each of your methods does what it is supposed to do. You may
then scale up to larger arrays. Pick whichever methods you think might be easiest to work on first
and make sure that they work before moving onto more dificult methods.
I have included a class called BMPGray that will take an array of gray scale pixel values and generate
an actual image. You can use this to see the results of your various manipulations. To use this,
you will need to read your file of pixel values into a two-dimensional array and then pass it to the
saveGrayBMP() method. I have provided an example showing how to use the BMPGray class.
# Deques
When you complete the methods in the Lab06Client class, the output of executing that class
should be
[white, blue, red]
[white, blue, red, red, white, green]
white
green
[blue, red, red, white, green]
[blue, red, white, green]
[red, white, green]
[red, white]
[orange, red, white]
orange
red
red
white
(Malus, domestica)
(Homo, sapien)
