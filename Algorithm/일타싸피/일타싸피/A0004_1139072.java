package 일타싸피;

import java.net.*;
import java.io.*;

public class A0004_1139072 {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "DAEJEON02_JAVA";

	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int) balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				// - order: 1인 경우 선공, 2인 경우 후공을 의미
				// - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				// 예) balls[0][0]: 흰 공의 X좌표
				// balls[0][1]: 흰 공의 Y좌표
				// balls[1][0]: 1번 공의 X좌표
				// balls[4][0]: 4번 공의 X좌표
				// balls[5][0]: 마지막 번호(8번) 공의 X좌표

				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];

				// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
				float targetBall_x = 0.0f;
				float targetBall_y = 0.0f;

				// width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
				float width = 0.0f;
				float height = 0.0f;

				// radian: width와 height를 두 변으로 하는 직각삼각형의 각도를 구한 결과
				// - 1radian = 180 / PI (도)
				// - 1도 = PI / 180 (radian)
				// angle : 아크탄젠트로 얻은 각도 radian을 degree로 환산한 결과
				double radian = height > 0 ? Math.atan(width / height) : 0;
				angle = (float) ((180.0 / Math.PI) * radian);

				// 구현 요소
				// 1. 현재 남아있는 공 파악 후 좌표값 가져오기
				// 2. 남아있는 공들의 위치를 파악 해 가까운 홀과의 각도 계산
				// 3.
				// 4. 선공 후공에 따라 목적구가 달라짐
				// 8번을 5번 인덱스로 둘 것
				// 선공 : 1 -> 3 -> 8
				// 후공 : 2 -> 4 -> 8

				boolean[] isTarget = new boolean[7]; // 총 6개 공에 대한 남아있는지 판단
				double[] distan = new double[6]; // 공과의 거리
				double[] holeDistance = new double[6]; // 남아있는 공과 홀간의 거리
				double hole_x = 0; // 넣어야 하는 홀 x 좌표
				double hole_y = 0; // 넣어야 하는 홀 x 좌표
				double min = Integer.MAX_VALUE; // 홀과의 최소 거리
				int index = 0; // 해당 홀의 인덱스
				double r = 5.73 / 2;

				for (int i = 1; i < 6; i++) {
					if (balls[i][0] > 0 && balls[i][1] > 0) {
						isTarget[i] = true;
						distan[i] = Math.sqrt(Math.pow(Math.abs(whiteBall_x - balls[i][0]), 2)
								+ Math.pow(Math.abs(whiteBall_y - balls[i][1]), 2));

					} else {
						isTarget[i] = false;
					}
				}
				
				// 해당 공이 남아 있는지 파악
				// 선공 : 1 -> 3 -> 5 순으로 파악
				// 후공 : 2 -> 4 -> 5 순으로 파악
				if (order == 1) {
					for (int i = 1; i < 6; i = i + 2) {
						if (isTarget[i] == true) {
							targetBall_x = balls[i][0];
							targetBall_y = balls[i][1];
							width = Math.abs(whiteBall_x - targetBall_x);
							height = Math.abs(whiteBall_y - targetBall_y);
							break;
						}
					}
				} else {
					for (int i = 2; i < 6; i = i + 2) {
						if (isTarget[i] == true) {
							targetBall_x = balls[i][0];
							targetBall_y = balls[i][1];
							width = Math.abs(whiteBall_x - targetBall_x);
							height = Math.abs(whiteBall_y - targetBall_y);
							break;
						}
					}
					if (isTarget[2] == false && isTarget[4] == false) {
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
						width = Math.abs(whiteBall_x - targetBall_x);
						height = Math.abs(whiteBall_y - targetBall_y);
					}
				}
				
				for(int i = 0; i < 6; i++) {
					holeDistance[i] = Math.sqrt(Math.pow(Math.abs(targetBall_x - HOLES[i][0]), 2)
							+ Math.pow(Math.abs(targetBall_y - HOLES[i][1]), 2));
				}
				
				// 넣어야 하는 홀의 위치 파악
				for (int i = 0; i < 6; i++) {
					if (min > holeDistance[i]) {
						min = holeDistance[i];
						index = i;
						hole_x = HOLES[index][0]; // x좌표
						hole_y = HOLES[index][1]; // y좌표
					}
				}

				if (Math.atan((hole_x) / (hole_y)) < Math.atan(height / width)) {
					double a = Math.sqrt(Math.pow(Math.abs(hole_x - whiteBall_x), 2) + Math.pow(Math.abs(hole_y - whiteBall_y), 2)); // 내 공과 홀 까지의 거리
					double c = min + 2 * r;
					float ga = (float) Math.atan(hole_x / hole_y);
					double ma = Math.abs(hole_x - targetBall_x) / Math.abs(hole_y - targetBall_y);
					double b = Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2) - 2 * a * c * Math.cos(ga - ma));
					float na = (float) Math.acos(((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
					angle = ga + na;
					angle = (float) Math.toDegrees(radian);
					System.out.println(a + " " + c + " " + ga + " " + b + " " + na + " " + angle);
					
				} else {
					double a = Math.sqrt(Math.pow(Math.abs(hole_x - whiteBall_x), 2) + Math.pow(Math.abs(hole_y - whiteBall_y), 2)); // 내 공과 홀 까지의 거리
					double c = min + 2 * r;
					float ga = (float) Math.atan(hole_x / hole_y);
					float ra = (float) Math.atan(Math.abs((hole_y - targetBall_y)) / Math.abs((hole_x - targetBall_x)));
					double b = Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2) - 2 * a * c * Math.cos(90 - ga - ra));
					float na = (float) Math.acos(((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
					
					angle = ga - na;
					angle = (float) Math.toDegrees(radian);
					System.out.println(hole_x + " " + hole_y + " " + a + " " + c + " " + ga + " " + b + " " + na + " " + angle);
				}

//				// 선공 후공에 따라 쳐야하는 공들중 가장 가까운 녀석의 인덱스를 구한다.
//				if(order == 1) {
//					for(int i = 1; i < 4; i = i + 2) {
//						if(distan[i] < min) {
//							min = distan[i];
//							index = i;
//							
//						}
//					}
//				}else {
//					for(int i = 2; i < 5; i = i + 2) {
//						if(distan[i] < min) {
//							min = distan[i];
//							index = i;
//						}
//					}
//				}

				// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
				if (whiteBall_x == targetBall_x) {
					if (whiteBall_y < targetBall_y) {
						angle = 0;
					} else {
						angle = 180;
					}
				} else if (whiteBall_y == targetBall_y) {
					if (whiteBall_x < targetBall_x) {
						angle = 90;
					} else {
						angle = 270;
					}
				}

				// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
				if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
					angle += 180;
				}

				// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y) {
					angle += 90;
				}

				// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도 재계산
				else if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y) {
					angle += 270;

				}

				// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도 재계산
				// 1사분면에서 90도를 빼서 y축을 기준으로한 각도를 계산할 수 있어야 한다.
				else if (whiteBall_x < targetBall_x && whiteBall_y < targetBall_y) {
					angle = Math.abs(angle - 90);
				}

				// distance: 두 점(좌표) 사이의 거리를 계산
				double distance = Math.sqrt((width * width) + (height * height));

				// power: 거리 distance에 따른 힘의 세기를 계산
				power = (float) distance;

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				// - angle: 흰 공을 때려서 보낼 방향(각도)
				// - power: 흰 공을 때릴 힘의 세기
				//
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
