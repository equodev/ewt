FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

# System dependencies for Flutter Linux desktop builds
RUN apt-get update && apt-get install -y \
    curl \
    git \
    unzip \
    xz-utils \
    zip \
    libglu1-mesa \
    cmake \
    ninja-build \
    pkg-config \
    libgtk-3-dev \
    clang \
    libblkid-dev \
    liblzma-dev \
    && rm -rf /var/lib/apt/lists/*

# JDK 23 (Eclipse Temurin 23.0.2+7)
RUN curl -L "https://github.com/adoptium/temurin23-binaries/releases/download/jdk-23.0.2%2B7/OpenJDK23U-jdk_x64_linux_hotspot_23.0.2_7.tar.gz" \
    | tar xz -C /opt
ENV JAVA_HOME=/opt/jdk-23.0.2+7
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Flutter SDK (version injected at build time)
ARG FLUTTER_VERSION
RUN curl -L "https://storage.googleapis.com/flutter_infra_release/releases/stable/linux/flutter_linux_${FLUTTER_VERSION}-stable.tar.xz" \
    | tar xJ -C /opt
ENV PATH="/opt/flutter/bin:${PATH}"
ENV CXXFLAGS="-std=c++17"

# Flutter refuses to run as root. Create a non-root user, transfer Flutter ownership,
# and run all Flutter setup as that user. CI jobs inherit this user via Kubernetes.
RUN useradd -ms /bin/bash ci \
    && chown -R ci:ci /opt/flutter
USER ci
ENV HOME=/home/ci
RUN git config --global --add safe.directory /opt/flutter \
    && flutter config --enable-linux-desktop \
    && flutter precache --linux
