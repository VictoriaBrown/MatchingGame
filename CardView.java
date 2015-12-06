package com.example.tori.matchinggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CardView extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = "CardView";
    private CardThread _thread;
    private final GameActivity gameActvity;
    // Array for game state, which card is flipped over...etc.
    private int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int width;
    private int height;

    class CardThread extends Thread {
        private SurfaceHolder _surfaceHolder;

        private CardView _panel;

        private boolean _run = false;

        // All variables go here:
        private Paint paint;
        private int nCards = 0;
        private int num1 = 0;
        private int num2 = 0;
        private int cardNum1 = 0;
        private int cardNum2 = 0;
        private int waitTime = 0;

        public CardThread(SurfaceHolder surfaceHolder, CardView panel) {
            _surfaceHolder = surfaceHolder;
            _panel = panel;
        }

        public void setRunning(boolean run) {
            _run = run;
        }

        @Override
        public void run() {
            Canvas c;
            while (_run) {
                c = null;
                try {
                    c = _surfaceHolder.lockCanvas(null);
                    synchronized (_surfaceHolder) {
                        // Update the game state
                        update();
                        // Draw the image
                        draw(c);
                    }
                } finally {
                    // Do this in a finally so that if an exception is thrown
                    // during the above, we don't leave the Surface in an
                    // inconsistent state
                    if (c != null) {
                        _surfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
        }

        public void initialize() {
            // Create paints, rectangles, init time, etc.
            paint = new Paint();
        }

        protected void update() {
            if (nCards == 2) {
                checkMatch();
            }
        }


        private void draw(Canvas canvas) {
            // Set paint to black for background:
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(3);
            // Draw background:
            canvas.drawRect(0, 0, width, height, paint);


            // Set paint for cards:
   //         paint.setColor(Color.WHITE);
     //       paint.setStrokeWidth(10);
            // Initialize the card backs (Draw cards):
            // FIRST ROW OF CARDS:
            // First card (first row):
   //         canvas.drawRect(90, 100, 235, 350, paint);
            // Second card (first row):
     //       canvas.drawRect(335, 100, 480, 350, paint);
            // Third card (first row):
       //     canvas.drawRect(580, 100, 725, 350, paint);
            // Fourth card (first row):
         //   canvas.drawRect(825, 100, 970, 350, paint);

            // SECOND ROW OF CARDS:
            // First card (2nd row):
           // canvas.drawRect(90, 450, 235, 700, paint);
            // Second card (2nd row):
            //canvas.drawRect(335, 450, 480, 700, paint);
            // Third card (2nd row):
  //          canvas.drawRect(580, 450, 725, 700, paint);
            // Fourth card (2nd row):
    //        canvas.drawRect(825, 450, 970, 700, paint);

            // THIRD ROW OF CARDS:
            // First card (3rd row):
      //      canvas.drawRect(90, 800, 235, 1050, paint);
            // Second card (3rd row):
        //    canvas.drawRect(335, 800, 480, 1050, paint);
            // Third card (3rd row):
          //  canvas.drawRect(580, 800, 725, 1050, paint);
            // Fourth card (3rd row):
   //         canvas.drawRect(825, 800, 970, 1050, paint);

            // FOURTH ROW OF CARDS:
            // First card (4th row):
     //       canvas.drawRect(90, 1150, 235, 1400, paint);
            // Second card (4th row):
       //     canvas.drawRect(335, 1150, 480, 1400, paint);
            // Third card (4th row):
         //   canvas.drawRect(580, 1150, 725, 1400, paint);
            // Fourth card (4th row):
           // canvas.drawRect(825, 1150, 970, 1400, paint);



            // If card need to be flipped back over:
            if (gameState[0] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(90, 100, 235, 350, paint);
            }
            if (gameState[1] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(335, 100, 480, 350, paint);
            }
            if (gameState[2] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(580, 100, 725, 350, paint);
            }
            if (gameState[3] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(825, 100, 970, 350, paint);
            }
            if (gameState[4] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(90, 450, 235, 700, paint);
            }
            if (gameState[5] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(335, 450, 480, 700, paint);
            }
            if (gameState[6] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(580, 450, 725, 700, paint);
            }
            if (gameState[7] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(825, 450, 970, 700, paint);
            }
            if (gameState[8] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(90, 800, 235, 1050, paint);
            }
            if (gameState[9] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(335, 800, 480, 1050, paint);
            }
            if (gameState[10] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(580, 800, 725, 1050, paint);
            }
            if (gameState[11] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(825, 800, 970, 1050, paint);
            }
            if (gameState[12] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(90, 1150, 235, 1400, paint);
            }
            if (gameState[13] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(335, 1150, 480, 1400, paint);
            }
            if (gameState[14] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(580, 1150, 725, 1400, paint);
            }
            if (gameState[15] == 0) {
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(10);
                canvas.drawRect(825, 1150, 970, 1400, paint);
            }




            // If any card is flipped draw appropriate symbol/color:
            if (gameState[0] == 1) {
                paint.setColor(Color.CYAN);
                canvas.drawOval(110, 120, 215, 330, paint);
                nCards += 1;
            }
            if (gameState[1] == 2) {
                paint.setColor(Color.RED);
                canvas.drawRect(355, 120, 460, 330, paint);
                nCards += 1;
            }
            if (gameState[2] == 3) {
                paint.setColor(Color.MAGENTA);
                canvas.drawRect(600, 120, 705, 330, paint);
                nCards += 1;
            }
            if (gameState[3] == 4) {
                paint.setColor(Color.BLACK);
                paint.setTextSize(125);
                canvas.drawText("♥", 825, 270, paint);
                nCards += 1;
            }
            if (gameState[4] == 5) {
                paint.setColor(Color.CYAN);
                canvas.drawRect(110, 470, 215, 680, paint);
                nCards += 1;
            }
            if (gameState[5] == 5) {
                paint.setColor(Color.CYAN);
                canvas.drawRect(355, 470, 460, 680, paint);
                nCards += 1;
            }
            if (gameState[6] == 4) {
                paint.setColor(Color.BLACK);
                paint.setTextSize(125);
                canvas.drawText("♥", 580, 620, paint);
                nCards += 1;
            }
            if (gameState[7] == 6) {
                paint.setColor(Color.YELLOW);
                paint.setTextSize(125);
                canvas.drawText("☀", 825, 620, paint);
                nCards += 1;
            }
            if (gameState[8] == 3) {
                paint.setColor(Color.MAGENTA);
                canvas.drawRect(110, 820, 215, 1030, paint);
                nCards += 1;
            }
            if (gameState[9] == 1) {
                paint.setColor(Color.CYAN);
                canvas.drawOval(355, 820, 460, 1030, paint);
                nCards += 1;
            }
            if (gameState[10] == 7) {
                paint.setColor(Color.BLUE);
                canvas.drawRect(600, 820, 705, 1030, paint);
                nCards += 1;
            }
            if (gameState[11] == 6) {
                paint.setColor(Color.YELLOW);
                paint.setTextSize(125);
                canvas.drawText("☀", 825, 970, paint);
                nCards += 1;
            }
            if (gameState[12] == 7) {
                paint.setColor(Color.BLUE);
                canvas.drawRect(110, 1170, 215, 1380, paint);
                nCards += 1;
            }
            if (gameState[13] == 8) {
                paint.setColor(Color.YELLOW);
                canvas.drawRect(355, 1170, 460, 1380, paint);
                nCards += 1;
            }
            if (gameState[14] == 2) {
                paint.setColor(Color.RED);
                canvas.drawRect(600, 1170, 705, 1380, paint);
                nCards += 1;
            }
            if (gameState[15] == 8) {
                paint.setColor(Color.YELLOW);
                canvas.drawRect(845, 1170, 950, 1380, paint);
                nCards += 1;
            }




            // If the cards need to disappear because user made a match:
            if (gameState[0] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(90, 100, 235, 350, paint);
            }
            if (gameState[1] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(335, 100, 480, 350, paint);
            }
            if (gameState[2] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(580, 100, 725, 350, paint);
            }
            if (gameState[3] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(825, 450, 970, 700, paint);
            }
            if (gameState[4] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(90, 450, 235, 700, paint);
            }
            if (gameState[5] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(335, 450, 480, 700, paint);
            }
            if (gameState[6] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(580, 450, 725, 700, paint);
            }
            if (gameState[7] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(825, 800, 970, 1050, paint);
            }
            if (gameState[8] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(90, 800, 235, 1050, paint);
            }
            if (gameState[9] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(335, 800, 480, 1050, paint);
            }
            if (gameState[10] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(580, 800, 725, 1050, paint);
            }
            if (gameState[11] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(825, 800, 970, 1050, paint);
            }
            if (gameState[12] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(90, 1150, 235, 1400, paint);
            }
            if (gameState[13] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(335, 1150, 480, 1400, paint);
            }
            if (gameState[14] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(580, 1150, 725, 1400, paint);
            }
            if (gameState[15] == 10) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawRect(825, 1150, 970, 1400, paint);
            }
        }

        protected void checkMatch() {
            // Loop through to waste time; to let user see 2nd card.
            if (waitTime < 500) {
                waitTime++;
            }

            // Loop number variable to keep track:
            int loopNum = 0;

            for (int number : gameState) {

                if (number != 0) {
                    // If num1 is empty:
                    if (num1 == 0) {

                        num1 = number;
                        cardNum1 = loopNum;
                    } else {
                        if (num1 != number) {
                            gameState[cardNum1] = 0;
                            gameState[number] = 0;
                            nCards = 0;
                        } else {
                            gameState[cardNum1] = 10;
                            gameState[number] = 10;

                        }
                    }
                }
                loopNum += 1;
            }
        }
    }



    public CardView(Context context) {
        super(context);
        getHolder().addCallback(this);
        this.gameActvity = (GameActivity) context;
        _thread = new CardThread(getHolder(), this);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    protected void calculateMove(float x, float y) {
        // Figure out which card has been selected:
        if (y < 350 && x < 235) {
            if (gameState[0] == 0) {
                gameState[0] = 1;
            }
        } else if (y < 350 && x < 500 && x > 300) {
            if (gameState[1] == 0) {
                gameState[1] = 2;
            }
        } else if (y < 350 && x < 725 && x > 580) {
            if (gameState[2] == 0) {
                gameState[2] = 3;
            }
        } else if (y < 350 && x < 970 && x > 825) {
            if (gameState[3] == 0) {
                gameState[3] = 4;
            }
        } else if (y < 700 && y > 450 && x < 235) {
            if (gameState[4] == 0) {
                gameState[4] = 5;
            }
        } else if (y < 700 && y > 450 && x < 480 && x > 300) {
            if (gameState[5] == 0) {
                gameState[5] = 5;
            }
        } else if (y < 700 && y > 450 && x < 730 && x > 500) {
            if (gameState[6] == 0) {
                gameState[6] = 4;
            }
        } else if (y < 700 && y > 450 && x > 825) {
            if (gameState[7] == 0) {
                gameState[7] = 6;
            }
        } else if (y < 1050 && y > 800 && x < 235) {
            if (gameState[8] == 0) {
                gameState[8] = 3;
            }
        } else if (y < 1050 && y > 800 && x < 480 && x > 335) {
            if (gameState[9] == 0) {
                gameState[9] = 1;
            }
        } else if (y < 1050 && y > 800 && x < 725 && x > 580) {
            if (gameState[10] == 0) {
                gameState[10] = 7;
            }
        } else if (y < 1050 && y > 800 && x > 825) {
            if (gameState[11] == 0) {
                gameState[11] = 6;
            }
        } else if (y > 1150 && x < 235) {
            if (gameState[12] == 0) {
                gameState[12] = 7;
            }
        } else if (y > 1150 && x < 480 && x > 335) {
            if (gameState[13] == 0) {
                gameState[13] = 8;
            }
        } else if (y > 1150 && x < 725 && x > 580) {
            if (gameState[14] == 0) {
                gameState[14] = 2;
            }
        } else if (y > 1150 && x > 825) {
            if (gameState[15] == 0) {
                gameState[15] = 8;
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        int width = w;
        int height = h;

        super.onSizeChanged(w, h, oldw, oldh);

        _thread.initialize();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // TODO Auto-generated method stub
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        _thread.setRunning(true);
        _thread.start();
    }



    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        _thread.setRunning(false);
        while (retry) {
            try {
                _thread.join();
                retry = false;
            } catch (InterruptedException e) {
                // We will try it again and again...
            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return super.onTouchEvent(event);

        Log.d(TAG, "onTouchEvent: x" + event.getX() + ",y " + event.getY());

        float x = event.getX();
        float y = event.getY();

        calculateMove(x, y);

        invalidate();   // request onDraw

        return true;
    }
}