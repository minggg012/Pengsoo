# Pengsoo
> 2022 여름 몰입캠프 2분반 윤창호 김민
- 펭수를 컨셉으로 하여 연락처, 갤러리, 지뢰찾기 게임을 구현한 어플리케이션입니다.

<img src = "https://user-images.githubusercontent.com/85171279/177310695-7c8e90b0-00b2-48cd-bc1e-dc50ffdfffaa.jpg" width = "180" height = "320"/> <img src = "https://user-images.githubusercontent.com/85171279/177288151-a5273a4c-9d1a-48cd-860e-54a07a03a961.jpg" width="180" height = "320"/> <img src = "https://user-images.githubusercontent.com/85171279/177288158-fc4e38c8-45e0-4f93-995d-85d563159f3f.jpg" width = "180" height = "320"/>


## A. 개발 팀원
- UNIST 컴퓨터공학과 [윤창호](https://github.com/ho9938)
- KAIST 전산학부 [김민](https://github.com/minggg012)

## B. 개발 환경
- OS: Android (targetSdk: 31)
- Language: Kotlin
- IDE: Android Studio
- Target Device: Galaxy S7

## C. 프로젝트 설명
### 1. TAB 1 : Contacts
<img src = "https://user-images.githubusercontent.com/85171279/177310839-e3f91364-1453-45c9-b7fc-94df2b6635a7.jpg" width = "180" height = "320"/> <img src = "https://user-images.githubusercontent.com/85171279/177310866-f444320d-3879-4b79-92d8-f91ba4aeead3.jpg" width = "180" height = "320"/> <img src = "https://user-images.githubusercontent.com/85171279/177310880-3b200e70-ea30-4494-851f-e4593739b14a.jpg" width = "180" height = "320"/>

#### Major Features
- 위 아래로 스와이프하여 모든 연락처를 확인할 수 있습니다.
- 연락처를 길게 클릭하여 원본 json file을 확인할 수 있습니다.
- 연락처를 짧게 클릭하여 상세정보를 확인할 수 있습니다.

#### Implementation Methods
- Recycler View를 이용하여 연락처를 보여준다.
- json file 형식으로 데이터를 받아와 연락처와 상세정보를 구성한다.
- ClickListner를 이용해 연락처를 짧게 클릭한 경우 해당 연락처의 상세정보를 보여주는 subActivity를 띄운다.
- LongClickListner를 이용해 연락처를 길게 클릭한 경우 해당 연락처의 원본 json file을 보여주는 toast를 띄운다. 

------------------

### 2. TAB 2 : Gallery
<img src = "https://user-images.githubusercontent.com/85171279/177288151-a5273a4c-9d1a-48cd-860e-54a07a03a961.jpg" width="180" height = "320"/> <img src = "https://user-images.githubusercontent.com/85171279/177306512-637f3cc7-b49b-4eb2-bdaa-519ca4d50c04.png" width = "180" height = "320" /> <img src = "https://user-images.githubusercontent.com/85171279/177305358-bda53fe1-0636-4eac-82f7-f57b80144193.png" width = "180" height = "320"/>

#### Major Features
- 위 아래로 스와이프하여 갤러리에 있는 사진을 확인할 수 있습니다.
- 사진을 짧게 클릭하여 사진을 크게 볼 수 있습니다. 
  - 우측 상단에 위치한 메뉴를 눌러 사진의 정보를 확인할 수 있습니다.
- 사진을 길게 클릭하여 사진을 삭제할 수 있습니다.

#### Implementation Methods
- Recycler View와 GridLayoutManager를 이용하여 갤러리에 있는 사진들을 grid 형식으로 보여주고, 위 아래로 스와이프할 수 있도록 한다.
- ClickListener를 이용해 사진을 짧게 클릭한 경우 사진이 크게 보이게 하는 subActivity를 띄운다.
  - 해당 Activity에서 toolbar와 menu를 이용하여 inform을 눌렀을 때 사진에 해당하는 정보를 다이얼로그 창에 띄운다.
- LongClickListner를 이용해 사진을 길게 클릭한 경우 사진이 들어있는 dataset에서 해당 사진을 삭제한 후 adapter.notifyDataSetChanged()를 이용하여 갤러리를 재구성한다.

----------------------

### 3. TAB 3 : MineSweeper
<img src = "https://user-images.githubusercontent.com/85171279/177310152-3708d760-3e0a-49e5-bf0e-bcb3f34f53ce.jpg" width = "180" height = "320"/> <img src = "https://user-images.githubusercontent.com/85171279/177310527-bbbdcccc-5a2a-450f-8232-a406c8cb2339.jpg" width = "180" height = "320"/> <img src = "https://user-images.githubusercontent.com/85171279/177310593-06f80b89-2a3f-470e-8c82-9d586797df3e.jpg" width = "180" height = "320"/> <img src = "https://user-images.githubusercontent.com/85171279/177310050-3a1329a8-6f59-407a-a907-9d651f76a3c7.jpg" width = "180" height = "320"/> 

#### Major Features
- 10 * 10 형식의 일반적인 지뢰찾기 게임입니다.
- 처음 entry를 클릭했을 때, timer가 시작됩니다.
- entry를 짧게 클릭하여 뒤집을 수 있습니다.
- 길게 클릭하여 flag를 세우거나 없앨 수 있습니다.
  - flag를 세울 때마다 remaining mines의 개수가 1씩 작아집니다.
- 게임이 끝나는 조건
  - 지뢰를 뒤집은 경우 'FAIL' 메시지가 뜨며 그에 해당하는 이미지로 바뀝니다.
  - 지뢰를 제외한 모든 entry를 뒤집은 경우 'SUCCEED' 메시지가 뜨며 그에 해당하는 이미지로 바뀝니다.
- 위쪽 가운데에 있는 펭수 이미지를 눌러 게임을 새로 시작할 수 있습니다.

#### Implementation Methods
- Recycler View와 GridLayoutManager를 이용하여 지뢰찾기 맵을 보여준다. 
  - Map이 initialize될 때
    - random()을 이용하여 지뢰의 위치와 게임 성공/실패시 뜰 이미지가 랜덤하게 정해지도록 한다.
    - timer를 0으로 설정한다.
- ClickListener를 이용하여 entry를 짧게 클릭한 경우 adapter.notifyItemChanged()를 이용하여 해당 entry에 해당하는 이미지(지뢰, 숫자, 빈땅)가 뜨도록 한다.
- LongClickListener를 이용하여 entry를 길게 클릭한 경우 adapter.notifyItemChanged()를 이용하여 flag가 뜨도록 한다.
- ClickListener를 이용하여 reset(펭수 이미지)을 클릭한 경우 map을 initialize한다.
